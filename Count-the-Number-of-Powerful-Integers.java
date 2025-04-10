class Solution {
    // Set<Long> li=new LinkedHashSet<>();
    public long count(String num,int limit,String s){
        if(num.length()<s.length())
        return 0;
        if(num.length()==s.length()){
            if(num.compareTo(s)>=0)
            return 1;
            else
            return 0;
        }
        String x=num.substring(num.length()-s.length());
        long res=0;
        int n=num.length()-s.length();
        for(int i=0;i<=n;i++){
            if(num.charAt(i)-'0'>limit){
                res+=(long)Math.pow(limit+1,n-i);
                return res;
            }
            res+=(long)(num.charAt(i)-'0')*(long)Math.pow(limit+1,n-i-1);
            
        }
        if(x.compareTo(s)>=0)
        res++;
        return res; 
    }
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String st=String.valueOf(start-1);
        String fin=String.valueOf(finish);
        return count(fin,limit,s)-count(st,limit,s);
        // System.out.println(li);
        // return li.size();
    }
}