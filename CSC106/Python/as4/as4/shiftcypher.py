
# This function will return a number between 0 and 25
# that corresponds to the position in the alphabet of
# the character.
def getNumForChar(char):
	return ord(char)-65

# This function will return a character that appears at
# position num in the alphabet.
def getCharForNum(num):
	return chr(num+65)


def encryptString(mystr,shift):
	length = len(mystr)
	encr = []

	for i in range(0,length):
		if (getNumForChar(mystr[i])+shift) < 26:
			temp = getNumForChar(mystr[i])+shift
		else:
			temp = getNumForChar(mystr[i])+shift-26

		encr[:0] = getCharForNum(temp)

	out = ""

	for j in range(0,length):
		out = out + encr.pop()
	return out

def decryptString(mystr,shift):

	length = len(mystr)
	encr = []

	for i in range(0,length):
		if (getNumForChar(mystr[i])-shift) > -1:
			temp = getNumForChar(mystr[i])-shift
		else:
			temp = getNumForChar(mystr[i])-shift+26

		encr[:0] = getCharForNum(temp)

	out = ""

	for j in range(0,length):
		out = out + encr.pop()
	return out
