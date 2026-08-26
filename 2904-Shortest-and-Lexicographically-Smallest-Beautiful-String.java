class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        StringBuilder str=new StringBuilder();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            int count=0;
            int len=0;
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<s.length();j++){
                sb.append(s.charAt(j));
                len++;
                if(s.charAt(j)=='1'){
                    count++;
                }
                if(count==k){
                if(len<min || (len==min && sb.toString().compareTo(str.toString())<0)){
                    min=Math.min(min,len);
                    str.setLength(0);
                    str.append(sb);}
                    break;
                 }
            }
        }
        return str.toString();
    }
}