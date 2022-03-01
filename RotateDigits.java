class RotateDigits {
    public int isMirrored(int n) {
        if(n == 1 || n == 0 || n == 8) return n;
        
        else if(n == 2) return 5;
        
        else if(n == 5) return 2;
        
        else if(n == 6) return 9;
        
        else if(n == 9) return 6;
        
        else {
            return -1;
        }
    }
    
    public int rotatedDigits(int n) {
        int count = 0;
        int num;
        boolean flag = true;
        int number = 0;
        int temp;
        
        for(int i = 1 ; i<=n ; i++) {
            num = i;
            flag = true;
            number = 0;
            
            while(num != 0) {
                temp = isMirrored(num % 10);
                
                if(temp == -1) {
                    flag = false;
                    break;
                }
                
                if(temp == 5 || temp == 6 || temp == 2 || temp == 9) {
                    number++;
                }
                
                num = num/10;
            }
            
            if(flag == true && number != 0) {
                count++; 
            }
        }
        return count;
    }
}