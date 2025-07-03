class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb=new StringBuilder();
        sb.append("a");
        while(sb.length()<k){
        StringBuilder sb1=new StringBuilder();
            for(int i=0;i<sb.length();i++){
                char a=sb.charAt(i);
                if(a>'z'){
                    a=(char)(a-'z');
                }
                sb1.append((char)(a+1));
            }
            sb.append(sb1);
        }
        // System.out.println(sb);
        return sb.charAt(k-1);
    }
}