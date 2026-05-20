class Solution {
    List<String> ans = new ArrayList<>();
    HashMap<Character,List<Character>> hm = new HashMap<>();
    public void backTrack(String digits,int i,String s){
        if(i==digits.length())
        {
            ans.add(new String(s));
            return;
        }
        char digit = digits.charAt(i);
        List<Character> list = hm.get(digit);
        for(int idx=0;idx<list.size();idx++)
        {
            backTrack(digits,i+1,s+list.get(idx));
        }

    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return ans;
        ArrayList<Character> list = new ArrayList<>(Arrays.asList('a','b','c'));
        hm.put('2', list);
         list = new ArrayList<>(Arrays.asList('d','e','f'));
        hm.put('3', list);
         list = new ArrayList<>(Arrays.asList('g','h','i'));
        hm.put('4', list);
         list = new ArrayList<>(Arrays.asList('j','k','l'));
        hm.put('5', list);
         list = new ArrayList<>(Arrays.asList('m','n','o'));
        hm.put('6', list);
         list = new ArrayList<>(Arrays.asList('p','q','r','s'));
        hm.put('7', list);
         list = new ArrayList<>(Arrays.asList('t','u','v'));
        hm.put('8', list);
         list = new ArrayList<>(Arrays.asList('w','x','y','z'));
        hm.put('9', list);
        backTrack(digits,0,"");
        return ans;
    }
}
