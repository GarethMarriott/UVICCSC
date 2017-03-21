
# should return the number of even numbers
# in the array A
def countEven(A):
	sum = 0
	for i in range(len(A)):
		if A[i]%2 == 0:
			sum = sum + A[i]
	return sum;
# should return the sum of every Nth number,
# starting with the elemenet at index 0
def sumEveryN(A, N):
	sum = 0
	for i in range(len(A)):
		if i%N == 0:
			sum = sum + A[i]
	return sum
