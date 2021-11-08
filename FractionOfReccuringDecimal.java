class FractionOfReccuringDecimal {
    
    public String fractionToDecimal(int num, int den) {
        //base case
        if(num==0)
            return "0";
        
        //converting all integers to num becuase we may multiply them with 10 also multiple time.
        long numerator=num;
        long denominator=den;
        
        //chekcing what sign our result should have 
        boolean flag=false;
        
        if((numerator<0 && denominator>=0) || (numerator>=0 && denominator<0))
            flag=true;
        
        //and removing sign from den and num
        numerator=Math.abs(numerator);
        denominator=Math.abs(denominator);
        
        
        long divider=numerator/denominator;
        long rem=numerator%denominator;
        
        StringBuilder op;
        if(rem==0){//no need to move further ,just return the results..
            op=(new StringBuilder()).append(divider);
        }else{//we have to find fractional points
            //we always multiply rem by 10 once then move forwad in case of remainder
            op= (new StringBuilder()).append(divider).append(".").append(fraction(rem*10,denominator,new StringBuilder(),new HashMap<Long,Integer>()));
        }
        //System.out.println(op.toString());
        if(flag)
            op.insert(0,'-');
        return op.toString();
    }
                           
    //while finding fractionals numbers we keep track of waht we have found till now 
    //so we can just stop if we have already found solution for current situation and append parenthises as asked in question.
    public StringBuilder fraction(long num,long den,StringBuilder sb,HashMap<Long,Integer> hm){
        
        //if we solved it before just append () at appropriate indices
        if(hm.containsKey(num)){
            int index=hm.get(num);
            sb.insert(index,'(');
            sb.append(')');
            return sb;
        }
        
        if(num<den){//we have to multiply num with 10.
            sb.append(0);//to do so we first have to append 0 in divider
            return fraction(num*10,den,sb,hm);
        }
        
        long divider=num/den;
        long rem=num%den;
        
        if(rem==0){
            return sb.append(divider);
        }else{
            hm.put(num,sb.length());
            sb.append(divider);
            return fraction(rem*10,den,sb,hm);
        }
    }
	//if you find this helpful then please up vote.
}