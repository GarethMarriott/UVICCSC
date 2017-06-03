/* uninitialized_local.c


   B. Bird - 05/04/2017
*/

#include <stdio.h>


int main(){
	unsigned short A = 0xABCD;
	unsigned short B = 0x0123;
	int r = 0;
	int d = 0;
	int count = 0;
	while (A>=B) {
		A=A-B;
		count++;
	}
	d=count;
	r=A;
	printf("\nd=%u\n" , d);
	printf("\nr=%u\n" , r);
	return 0;
}
