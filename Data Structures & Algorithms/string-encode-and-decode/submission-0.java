class Solution {

    public String encode(List<String> strs) {
        String s = "";
        for(String str:strs){
            s=s+Integer.toString(str.length())+"#"+str;
        }
        return s;

    }

    public List<String> decode(String str) {
        List<String> s = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#')
                j++;
            int len = Integer.parseInt(str.substring(i,j));
            j++;
            s.add(str.substring(j,j+len));
            i=j+len;

        }
        return s;
    }
}
