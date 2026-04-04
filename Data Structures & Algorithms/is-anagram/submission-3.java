class Solution {
    public boolean isAnagram(String s, String t) {
        int count1[] = new int[26];
        int count2[] = new int[26];
        //System.out.println((int)s.charAt(1));
        for(int i=0;i<s.length();i++)
            count1[(int)s.charAt(i)-97]++;
        for(int i=0;i<t.length();i++)
            count2[(int)t.charAt(i)-97]++;
        for(int i=0;i<26;i++)
        {
            if(count1[i]!=count2[i])
                return false;
        }
        return true;


    }
}
