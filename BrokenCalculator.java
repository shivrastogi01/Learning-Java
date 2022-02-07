class BrokenCalculator {
public int brokenCalc(int startValue, int target) {
    if(target < startValue)
    {
        return startValue - target;
    }
    
    int ops = 0;
    while(target > startValue)
    {
        if(target%2 == 1)
        {
            target += 1;
            ops++;
        }
        
        target = target/2;
        ops++;
    }
    
    ops += (startValue-target);
    return ops;
}
}