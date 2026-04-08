class Solution {
    public boolean lemonadeChange(int[] nums) {
        int[] have=new int[3];
        for(int i=0;i<nums.length;i++){
        
      
                if(nums[i]==5)
                {
                    have[0]++;
                }
                else if(nums[i]==10)
                {
                    have[0]--;
                    if(have[0]<0)
                        return false;
                    have[1]++;
                }
                else if(nums[i]==20)
                {
                    if(have[0]>=1 && have[1]>=1){
                        have[0]--;
                        have[1]--;
                    }
                    else{
                        have[0]=have[0]-3;
                    }
                    if(have[0]<0 || have[1]<0)
                        return false;
                    have[2]++;
                }
                System.out.println(have[0]+" "+have[1]+" "+have[2]);

            
        }
        if(have[0]<0 || have[1]<0 || have[2]<0)
        return false;
        return true;
        
    }
}