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


# print(format(header(["get","ack"] , 1000 , 1000) , 'b').encode())
print(repr(encode_header(["get","ack"] , 1005 , 7 , 69)))
v = decode_header(encode_header(["get",'syn','ack'] , 1 , 7 , 69))
print(v)
