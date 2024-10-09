class Solution {
    public int minAddToMakeValid(String s) {
        int o=0,c=0;
        for(char i:s.toCharArray()){
            if(i=='(')
            o++;
            else{
            if(o==0)
            c++;
            else
            o--;
            }
        }
        return o+c;
    }
}