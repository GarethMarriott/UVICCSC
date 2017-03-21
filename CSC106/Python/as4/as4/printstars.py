
# this function prints num_stars stars followed
# by a newline character
def printStars(num_stars):
	for i in range(0,num_stars):
		print"*",
	print

def printSquare(width):
	for i in range(width):
		printStars(width)

def printTriangle(width):
	for i in range(width):
		printStars(i+1)

def printTriangleRecursive(cur_width,width):
	if cur_width<width:
		printTriangleRecursive(cur_width+1,width)
	printStars(width - cur_width + 1)


def printFlippedTriangle(width):
	for i in range(width):
		for j in range(width-i-1):
			print " ",
		printStars(i+1)
