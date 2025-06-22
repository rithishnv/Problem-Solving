class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n=s.length();
        int n1=(int)Math.ceil((double)n/k);
        String[] res=new String[n1];
        int j=0;
        int i=0;
        for(i=0;i+k<=n;i+=k){
            res[j++]=s.substring(i,i+k);
        }
        if(j<n1){
        StringBuilder sb=new StringBuilder(s.substring(i,s.length()));
        while(sb.length()!=k){
            sb.append(fill);
        }
        res[n1-1]=sb.toString();
        }
        return res;
    }
}