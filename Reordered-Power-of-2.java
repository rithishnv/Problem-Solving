class Solution {
    public boolean reorderedPowerOf2(int n) {
        if(n==1)
        return true;
        Map<Integer,Integer> map=new HashMap<>();
        int n1=n;
        int c=0;
        while(n1>0){
            int k=n1%10;
            map.put(k,map.getOrDefault(k,0)+1);
            c++;
            n1/=10;
        }
        n1=1;
        while(true){
            n1*=2;
            String s=""+n1;
            if(s.length()>c)
            return false;
            else if(s.length()==c){
                Map<Integer,Integer> t=new HashMap(map);
                int n2=n1;
                int f=0;
                while(n2>0){
                    if(t.getOrDefault(n2%10,0)!=0){
                        t.put(n2%10,t.get(n2%10)-1);
                    }
                    else{
                        f=1;
                    break;
                    }
                    n2/=10;
                }
                if(f==0)
                return true;
            }
        }
        // return false;
    }
}