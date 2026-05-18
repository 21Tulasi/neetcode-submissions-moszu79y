class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int[] res = new int[num1.length()+num2.length()];
        num1= new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        for(int i=0;i<num1.length();i++){
            for(int j=0;j<num2.length();j++){
                int digit = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                res[i+j]+=digit;
               
                if((res[i+j]/10) >0)
                    res[i+j+1]+=res[i+j]/10;
                res[i+j]%=10;
                 
            }
        }
        String s="";
        for(int i=res.length-1;i>=0;i--){
            if(i==res.length-1 && res[i]==0) continue;
            s+=Integer.toString(res[i]);}
        return s;
    }
}
