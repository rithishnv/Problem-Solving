class Solution {
    public String clearDigits(String s) {
        StringBuilder sb=new StringBuilder();
        int j=0;
        for(char i:s.toCharArray()){
            if(i>='0' && i<='9'){
                sb.deleteCharAt(j-1);
                j--;
            }
            else{
            sb.append(i);
            j++;
            }
        }
        return sb.toString();
    }
}