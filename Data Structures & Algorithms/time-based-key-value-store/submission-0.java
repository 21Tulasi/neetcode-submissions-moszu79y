class TimeMap {
    class Pair{
        int i;
        String val;
        Pair(int i,String val){
            this.i=i;
            this.val=val;
        }
    }
    HashMap<String,ArrayList<Pair>> hm;
    public TimeMap() {
       hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {    
            Pair p = new Pair(timestamp,value);
            hm.computeIfAbsent(key,k->new ArrayList<Pair>()).add(p);     
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)) return "";
        int floor=-1;
        ArrayList<Pair> al = hm.get(key);
        int low=0;
        int high=al.size()-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(al.get(mid).i<=timestamp){
                floor=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        System.out.println(floor);
        if(floor==-1) return "";
        return al.get(floor).val;

    }
}

