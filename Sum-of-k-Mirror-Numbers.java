class Solution {
    public long kMirror(int k, int n) {
        long sum=0;
        long cnt=0;
        for(int i=1;;i++){
            List<Long> li=new ArrayList<>();
            generate(0,i,new StringBuilder(),li,k);
            for(long j:li){
                if(check(j)){
                    sum+=j;
                    cnt++;
                    if(cnt==n)
                    return sum;
                }
            }
        }
    }
    public boolean check(long num){
        long l=num;
        long r=0;
        while(num>0){
            r=r*10+num%10;
            num/=10;
        }
        return l==r;
    }
    public void generate(int ind,int len,StringBuilder sb,List<Long> li,int k){
        if(ind>=(len+1)/2){
            li.add(form(sb,len,k));
            return;
        }
        for(int i=0;i<k;i++){
            if(ind==0 && i==0)
            continue;
            sb.append(i);
            generate(ind+1,len,sb,li,k);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }
    public long form(StringBuilder sb,int len,int k){
        String l=sb.toString();
        String r=new StringBuilder(l.substring(0,len/2)).reverse().toString();
        String re=l+r;
        return Long.parseLong(re,k);
    }
}