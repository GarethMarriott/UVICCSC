# Code started from: https://pythontic.com/modules/socket/udp-client-server-example

import time
import socket


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

    return "{:08b}".format(byte_pkt_type) + "{:016b}".format(seq_number) + "{:016b}".format(ack_number) + "{:016b}".format(payload_size)


def decode_header(header):
    byte_pkt_type = header[0:8]
    seq_number    = header[8:24]
    ack_number    = header[24:40]
    payload_size  = header[40:56]
    get = True if byte_pkt_type[3] == '1' else False
    syn = True if byte_pkt_type[4] == '1' else False
    ack = True if byte_pkt_type[5] == '1' else False
    fin = True if byte_pkt_type[6] == '1' else False
    data = True if byte_pkt_type[7] == '1' else False
    return {'get':get,'syn':syn,'ack':ack,'fin':fin,'data':data,'seq_number':seq_number,'ack_number':ack_number,'payload_size':payload_size}


localIP     = "10.0.0.1"
localPort   = 20001
bufferSize  = 2048
time        = 0




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

        header  = decode_header(message[0:56])
        payload = message[56:]

        print("\n------S------")
        print("Header: " + str(header))
        print("Message: " + payload)
        print("Client IP Address: " + address_ip + ":" + str(address_port))
        print("------------\n")

        if header['syn']:
            msgFromServer       = encode_header(["syn","ack"],0,0,0)
            print("to client -> " + msgFromServer)
            bytesToSend         = str.encode(msgFromServer)
            UDPServerSocket.sendto(bytesToSend, address)
            UDPServerSocket.settimeout(1)
        elif header['get']:
            msgFromServer       = encode_header(["ack"],0,0,0)
            print("to client -> " + msgFromServer)
            bytesToSend         = str.encode(msgFromServer)
            UDPServerSocket.sendto(bytesToSend, address)
            UDPServerSocket.settimeout(1)
        elif header['ack']:
            UDPServerSocket.settimeout(None)
        else:
            msgFromServer       = encode_header(["ack"],header['seq_number'],header['ack_number'],0)
            print("to client -> " + msgFromServer)
            bytesToSend         = str.encode(msgFromServer)
            UDPServerSocket.sendto(bytesToSend, address)
    except Exception as e:
        print("Timeout attemping retransmit")
        bytesToSend = str.encode(msgFromServer)
        UDPServerSocket.sendto(bytesToSend, address)
        UDPServerSocket.settimeout(1)
