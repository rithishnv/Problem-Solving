1class Solution {
2    public char nextGreatestLetter(char[] letters, char target) {
3        for(char i:letters){
4            if(i>target)
5            return i;
6        }
7        return letters[0];
8    }
9}