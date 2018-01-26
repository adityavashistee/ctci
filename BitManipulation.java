class BitManipulation{

	public static boolean check(int n){
		// check if n is of power 2
		return ((n & (n-1))==0);
	}

	public static int noBitsRequiredToConvert(int a, int b){
		int c= a^b; // will give the different bits;
		int count=0;
		while(c!=0){
			if(c%2!=0) count++;
			c=c>>1;
		}
		return count;
	}

	public static int swapTheAlternateBits(int n){
		int k=0xaaaaaaaa, i=0x55555555;
		int output=((n&k) >>1) | ((n&i) << 1);
		return output;
	}

	public static int insertNumber(int n, int m, int i, int j){
		int mask=0xffffffff;
		int k=i;
		int a=1;
		a=a<<i;
		while(i<=j){
			mask=mask-a;
			a=a<<1;
			i++;
		}
		System.out.println(mask);
		int output=(mask & n ) | (m<<k);
		return output; 
	}

	public static String doubleToBinary(double d){
		String output="0.";
		int k=0;
		while(k < 32 && d>0){
			d=2*d;
			if(d>=1) {
				output=output+"1";
				d=d-1;
			}
			else{
				output=output+"0";
			}
			k++;
		}
		System.out.println(d);
		if(d!=0) output="Error";
		return output;
	}

	public static void main(String[] args){
		
		System.out.println(check(16));
		System.out.println(check(19));

		System.out.println(noBitsRequiredToConvert(31,14));
		System.out.println(swapTheAlternateBits(2));
		System.out.println(insertNumber(1024, 10,2, 5));
		System.out.println(doubleToBinary(0.75));

		//System.out.println("bit manipulation");
	}
}
