# Code started from: https://pythontic.com/modules/socket/udp-client-server-example

# Gareth Marriott
# V00875748
# gpmarriott3@gmail.com

import time
import socket
import os
import sys


localIP     = sys.argv[1]
localPort   = int(sys.argv[2])
bufferSize  = 1024
header_size = 88
timer       = 0
payload_max = 900
FILE        = ""
FILE_SIZE   = 0
CACHED_FILE = ""

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

    return "{:08b}".format(byte_pkt_type) + "{:032b}".format(seq_number) + "{:032b}".format(ack_number) + "{:016b}".format(payload_size)


def decode_header(header):
    byte_pkt_type = header[0:8]
    seq_number    = header[8:40]
    ack_number    = header[40:72]
    payload_size  = header[72:88]
    get = True if byte_pkt_type[3] == '1' else False
    syn = True if byte_pkt_type[4] == '1' else False
    ack = True if byte_pkt_type[5] == '1' else False
    fin = True if byte_pkt_type[6] == '1' else False
    data = True if byte_pkt_type[7] == '1' else False
    return {'get':get,'syn':syn,'ack':ack,'fin':fin,'data':data,'seq_number':seq_number,'ack_number':ack_number,'payload_size':payload_size}

def get_file_data(start_byte,payload_size):
    # print("IN filename -> "+FILE_NAME)
    # if start_byte != 0:
    #     file_string = FILE.seek(start_byte,0)
    # file_string = FILE.read(payload_size)
    # print(file_string)
    if start_byte+payload_size >= len(CASHED_FILE):
        return str(CASHED_FILE[start_byte:])
    else:
        return str(CASHED_FILE[start_byte:start_byte+payload_size])


# Create a datagram socket
UDPServerSocket = socket.socket(family=socket.AF_INET, type=socket.SOCK_DGRAM)

# Bind to address and ip
UDPServerSocket.bind((localIP, localPort))

print("server up and listening")

msgFromServer = ""
address = 0

# Listen for incoming datagrams
while(True):
    try:
        bytesAddressPair = UDPServerSocket.recvfrom(bufferSize)

        message_bytes = bytesAddressPair[0]
        address       = bytesAddressPair[1]
        message       = message_bytes.decode("utf-8")
        address_ip    = address[0]
        address_port  = address[1]

        header  = decode_header(message[0:88])
        payload = str(message[88:])


        # print("\n------S------")
        # print("Header: " + str(header))
        # print("Message: " + repr(payload))
        # print("Client IP Address: " + address_ip + ":" + str(address_port))
        # print("------------\n")
        if header['syn'] and header['ack']:
            print("SYN compleate, awaiting GET")
            UDPServerSocket.settimeout(None)
        elif header['syn']:
            msgFromServer       = encode_header(["syn","ack"],0,0,0)
            # print("to client -> " + msgFromServer)
            bytesToSend         = str.encode(msgFromServer)
            UDPServerSocket.sendto(bytesToSend, address)
            UDPServerSocket.settimeout(1)
            # time.sleep(.1)
        elif header['get']:
            FILE_NAME = payload
            print("File requested -> " + FILE_NAME)
            FILE = open(FILE_NAME,'r')
            CASHED_FILE = FILE.read()
            FILE_SIZE = len(CASHED_FILE)
            payload_to_client   = get_file_data(0 , payload_max)
            # print('payload length -> ' + str(len(payload_to_client)))
            msgFromServer       = encode_header(['data'],0,0,len(payload_to_client))
            # print("to client after get -> " + msgFromServer)
            bytesToSend         = str.encode(msgFromServer + payload_to_client)
            UDPServerSocket.sendto(bytesToSend, address)
            UDPServerSocket.settimeout(1)
            # time.sleep(.1)
        elif header['fin']:
            print("File transfer compleate awaiting next connection\n")
            FILE.close()
            UDPServerSocket.settimeout(None)
        elif header['ack']:
            # print(int(header['seq_number'] , 2))
            # print(FILE_SIZE)
            payload_to_client   = get_file_data(int(header['ack_number'],2) , payload_max)
            # print(payload_to_client)
            # print(len(payload_to_client))
            if len(payload_to_client) == 0:
                msgFromServer       = encode_header(["fin","ack"],int(header['ack_number'],2),int(header['seq_number'],2),0)
                # print("to client -> " + msgFromServer)
                bytesToSend         = str.encode(msgFromServer)
                UDPServerSocket.sendto(bytesToSend, address)
                UDPServerSocket.settimeout(1)
            else:
                msgFromServer       = encode_header(['data'],int(header['ack_number'],2),int(header['seq_number'],2),len(payload_to_client))
                # print("to client after not end of file-> " + str(decode_header(str.encode(msgFromServer))))
                bytesToSend         = str.encode(msgFromServer + payload_to_client)
                UDPServerSocket.sendto(bytesToSend, address)
                UDPServerSocket.settimeout(1)
                # time.sleep(.1)
        else:
            pass
    except socket.timeout as e:
        print(type(e))
        print("Timeout attemping retransmit")
        bytesToSend = str.encode(msgFromServer)
        UDPServerSocket.sendto(bytesToSend, address)
        UDPServerSocket.settimeout(1)
        # time.sleep(.1)
