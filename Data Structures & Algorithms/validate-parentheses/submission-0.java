class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        Stack<Character> sta = new Stack<>();
        for(Character st:s.toCharArray()){
            if(st=='(' || st=='[' || st=='{')
                sta.push(st);
            
            else{
                if(sta.isEmpty()) return false;
                if(st==')' && sta.peek()!='(')
                    return false;
                if(st==']' && sta.peek()!='[')
                    return false;
                if(st=='}' && sta.peek()!='{')
                    return false;
                sta.pop();

            }
            
        }
        if(sta.size()==0)
                return true;
        return false;
        
    }
}
