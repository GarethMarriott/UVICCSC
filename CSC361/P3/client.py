# Code started from: https://pythontic.com/modules/socket/udp-client-server-example

# Gareth Marriott
# V00875748
# gpmarriott3@gmail.com

import socket
import time
import sys


def encode_header(pkt_type, seq_number, ack_number, payload_size):
    byte_pkt_type = 1 if "get" in pkt_type else 0

    byte_pkt_type = byte_pkt_type << 1
    byte_pkt_type = byte_pkt_type + 1  if "syn" in pkt_type else byte_pkt_type

    byte_pkt_type = byte_pkt_type << 1
    byte_pkt_type = byte_pkt_type + 1  if "ack" in pkt_type else byte_pkt_type

    byte_pkt_type = byte_pkt_type << 1
    byte_pkt_type = byte_pkt_type + 1  if "fin" in pkt_type else byte_pkt_type

    byte_pkt_type = byte_pkt_type << 1
    byte_pkt_type = byte_pkt_type + 1  if "data" in pkt_type else byte_pkt_type

    # print("{:08b}".format(byte_pkt_type) + "{:032b}".format(seq_number) + "{:032b}".format(ack_number) + "{:016b}".format(payload_size))
    return "{:08b}".format(byte_pkt_type) + "{:032b}".format(seq_number) + "{:032b}".format(ack_number) + "{:016b}".format(payload_size)


def decode_header(header):
    byte_pkt_type = header[0:8]
    seq_number    = header[8:40]
    ack_number    = header[40:72]
    payload_size  = header[72:88]
    get  = True if byte_pkt_type[3] == '1' else False
    syn  = True if byte_pkt_type[4] == '1' else False
    ack  = True if byte_pkt_type[5] == '1' else False
    fin  = True if byte_pkt_type[6] == '1' else False
    data = True if byte_pkt_type[7] == '1' else False
    return {'get':get,'syn':syn,'ack':ack,'fin':fin,'data':data,'seq_number':seq_number,'ack_number':ack_number,'payload_size':payload_size}



serverAddressPort        = (sys.argv[1], int(sys.argv[2]))
bufferSize               = 1024
next_sequence_number     = 0
requested_file           = sys.argv[3]
# print(requested_file)

outfile = open(sys.argv[4],'w')

# Create a UDP socket at client side
UDPClientSocket = socket.socket(family=socket.AF_INET, type=socket.SOCK_DGRAM)

# Send to server using created UDP socket
payload = ""
msgFromClient = encode_header(['syn'] , 0 , 0 , 0)
bytesToSend = str.encode(msgFromClient)
UDPClientSocket.sendto(bytesToSend, serverAddressPort)

while True:
    try:
        bytesAddressPair = UDPClientSocket.recvfrom(bufferSize)

        message_bytes = bytesAddressPair[0]
        address       = bytesAddressPair[1]
        message       = message_bytes.decode("utf-8")
        address_ip    = address[0]
        address_port  = address[1]

        header  = decode_header(message[0:88])
        payload = message[88:]
        # print("\n-----Messaged-----")
        # print("Header: " + str(header))
        # print("header claimed payload size BYTES: " + str(header['payload_size']))
        # print("header claimed payload size: " + str(int(header['payload_size'] , 2)))
        # print("message len: " + str(len(payload)))
        # print("Message: " + repr(payload))
        # print("-----Recieved-----\n")

        if header['syn'] and header['ack']:
            msgFromClient = encode_header(['ack','syn'],0,0,0)
            bytesToSend = str.encode(msgFromClient)
            UDPClientSocket.sendto(bytesToSend, address)
            print("connection established")
            msgFromClient = encode_header(["get"],0,0,0)
            bytesToSend = str.encode(msgFromClient + requested_file)
            # print("-----Message-----\n"+str(decode_header(msgFromClient))+"\n-----Sent-----")
            UDPClientSocket.sendto(bytesToSend, address)
            print("File requested -> "+requested_file)
            UDPClientSocket.settimeout(1)
            time.sleep(.1)
        elif header['fin']:
            msgFromClient = encode_header(['ack','fin'],0,0,0)
            bytesToSend = str.encode(msgFromClient)
            # print("-----Message-----\n"+str(decode_header(msgFromClient))+"\n-----Sent-----")
            UDPClientSocket.sendto(bytesToSend, address)
            UDPClientSocket.close()
            outfile.close()
            print("File transfer compleate\n")
            # print("---------\nfin\n---------")
            break
        elif header['data']:
            outfile.write(payload)
            msgFromClient = encode_header(['ack'],0,int(header['seq_number'],2)+int(header['payload_size'],2),0)
            bytesToSend = str.encode(msgFromClient)
            print("Number of bytes recieved -> " + str(int(header['seq_number'],2)) + "\r", end = '')
            # print("-----Message-----\n"+str(decode_header(msgFromClient))+"\n-----Sent-----")
            UDPClientSocket.sendto(bytesToSend, address)
            UDPClientSocket.settimeout(1)
            time.sleep(.1)
        elif header['ack']:
            UDPClientSocket.settimeout(None)
            time.sleep(.1)
        else:
             UDPClientSocket.settimeout(None)
             time.sleep(.1)

    except Exception as e:
        # print(type(e))
        print("Timeout attemping retransmit\r" end = '')
        bytesToSend = str.encode(msgFromClient)
        UDPClientSocket.sendto(bytesToSend, serverAddressPort)
        UDPClientSocket.settimeout(1)
        time.sleep(.1)
