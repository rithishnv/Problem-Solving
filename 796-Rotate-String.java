class Solution {
    public boolean rotateString(String s, String goal) {
        // for(int i=0;i<s.length();i++){
        //     if(s.equals(goal))
        //     return true;
        //     s= s.substring(s.length()-1)+s.substring(0,s.length()-1);
        // }
        if(s.length()!=goal.length())
        return false;
        if((s+s).contains(goal))
        return true;
        return false;
    }
}