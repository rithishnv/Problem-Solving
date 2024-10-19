class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb=new StringBuilder("0");
        int i=1;
        while(i++<n){
            StringBuilder sb1=new StringBuilder(sb).reverse();
            for (int j = 0; j < sb1.length(); j++) {
                sb1.setCharAt(j, sb1.charAt(j) == '0' ? '1' : '0');
            }
            sb.append("1");
            sb.append(sb1);
        }
        return sb.charAt(k-1);
    }
}