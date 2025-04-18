class Solution {
    public String countAndSay(int n) {
        StringBuilder sb=new StringBuilder(\11\);
        if(n==1)
        return \1\;
        n-=2;
        while(n-->0){
            int f=1;
            StringBuilder b=new StringBuilder();
            for(int i=0;i<sb.length()-1;i++){
                if(sb.charAt(i)==sb.charAt(i+1)){
                    f++;
                }
                else{
                    b.append(f);
                    b.append(sb.charAt(i));
                    f=1;
                }
            }
            b.append(f+\\+sb.charAt(sb.length()-1));
            sb=b;
        }
        return sb.toString();
    }
}