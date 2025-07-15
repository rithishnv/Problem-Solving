class Solution {
    public boolean isValid(String word) {
        int res=0;
        if(word.length()<3)
        return false;
        boolean v=false,c=false;
        int j=0;
        for(char i:word.toCharArray()){
            // if(j>2 && v && c)
            // return true;
            if(i=='@' || i=='#' || i=='$')
            return false;
            if(i=='A'||i=='E'||i=='I'||i=='O'||i=='U'||i=='a'||i=='e'||i=='i'||i=='o'||i=='u')
            v=true;
            else if(!(i>='0'&&i<='9'))
            c=true;
            j++;
        }
        return v&&c;
    }
}