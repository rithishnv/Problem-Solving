class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int oneRem = 20000;
        int twoRem = 20000;
        
        for(int num : nums)
        {
            sum += num;
            
            if(num % 3 == 1)
            {
                twoRem = Math.min(twoRem, oneRem + num);
                oneRem = Math.min(oneRem, num); 
            }
            
            if(num % 3 == 2)
            {
                oneRem = Math.min(oneRem, twoRem + num);
                twoRem = Math.min(twoRem, num);
                 
            }
        }
        
        if(sum % 3 == 0)
            return sum;
        
        if(sum % 3 == 1)
            return sum - oneRem;
        
        if(sum % 3 == 2)
            return sum - twoRem;
        
        return 0;
            
    }
}