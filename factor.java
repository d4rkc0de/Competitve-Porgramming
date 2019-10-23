public static long[] factor(long n, int[] primes)
	{
		long[] ret = new long[20];
		int rp = 0;
		for(int p : primes){
			if((long)p * p > n)break;
			int i;
			for(i = 0;n % p == 0;n /= p, i++);
			if(i > 0){
				ret[rp] = p;
				rp++;
			}
		}
		if(n != 1){
			ret[rp] = n;
			rp++;
		}
		return Arrays.copyOf(ret, rp);
	}