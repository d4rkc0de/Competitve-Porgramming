    long[] gauss(long mod, long... y) {
        int n = y.length;
        long[] dp = new long[n+1];
        dp[0] = 1;
        for(int i = 0;i < n;i++){
            for(int j = i;j >= 0;j--){
                dp[j+1] += dp[j];
                if(dp[j+1] >= mod)dp[j+1] -= mod;
                dp[j] = dp[j]*-i%mod;
                if(dp[j] < 0)dp[j] += mod;
            }
        }

        long[] f = new long[n+1];
        f[0] = 1;
        for(int i = 1;i <= n;i++)f[i] = f[i-1] * i % mod;

        long[] ret = new long[n];
        for(int i = 0;i < n;i++){
            long den = f[i]*f[n-1-i]%mod;
            if(((i^n-1)&1) == 1){
                den = mod - den;
            }
            long iden = invl(den, mod) * y[i] % mod;

            long minus = 0;
            for(int j = n-1;j >= 0;j--){
                minus = (dp[j+1] + minus * i) % mod;
                ret[j] = (ret[j] + minus*iden)%mod;
            }
        }
        return ret;
    }

    public static long invl(long a, long mod) {
        long b = mod;
        long p = 1, q = 0;
        while (b > 0) {
            long c = a / b;
            long d;
            d = a;
            a = b;
            b = d % b;
            d = p;
            p = q;
            q = d - c * q;
        }
        return p < 0 ? p + mod : p;
    }


    // Application: You have a polynome of degree n P(x) = a0 + a1 * x + ... + an * x^n , pass to the gauss function an array y[], such that y[0] = P(0), ..., y[n] = P(n) ( n+1 different values) : 
    // the function will return an array that represent the coefficient of the polynome ( a0, a1, ..., an)

    // Example P(x) = 2 + x + 3*x^2 , y[0] = 2; y[1] = 6; y[2] = 16; the function will return 2, 1, 3.