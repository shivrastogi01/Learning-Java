class PrimePalindrome
{
    public int primePalindrome(int N)
    {
        int result = 0 ;
        if( N == 2 || N == 0 || N == 1 )
        {
            return 2 ;
        }
        if( N % 2 == 0 )
        {
            N++ ;
        }            
        while( true )
        {
            StringBuilder sb = new StringBuilder(Integer.toString(N));            
            if( N == Integer.parseInt( new String( sb.reverse()) ) && isPrime(N) )
            {
                return N ;
            }            
            N = N + 2 ;
            if( N > 11 && N < 100 )
            {
                N = 101 ;
            }
            if( N > 999 && N < 10000 )
            {
                N = 10001 ;
            }
            if( N > 99999 && N < 1000000 )
            {
                N = 1000001 ;
            }
            if( N > 9999999 && N < 100000000 )
            {
                N = 100000001 ;
            }
        }
    } 
    boolean isPrime( int N )
    {
        int i ;                    
        if( ( N & 1 ) == 0 && N != 2 )
        {
            return false ;
        }
        else if( N % 3 == 0 && N != 3 )
        {
            return false ;
        }                    
        else if( N % 11 == 0 && N != 11 )
        {
            return false ;
        }
        else if( N % 13 == 0 && N != 13 )
        {
            return false ;
        }
        else if( N % 17 == 0 && N != 17 )
        {
            return false ;
        }
        else
        {
            for( i = 3 ; i <= Math.sqrt(N) ; i += 2 )
            {
                if( N % i == 0 )
                {
                    return false ;
                }
            }
        }
        return true ;
    }
}