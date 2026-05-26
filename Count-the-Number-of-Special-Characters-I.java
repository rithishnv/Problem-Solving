1class Solution {
2    public int numberOfSpecialChars(String word) {
3        Set<Character> a1=new LinkedHashSet<>();
4        for(char i:word.toCharArray()){
5        if(i>=97)
6        continue;
7        a1.add(i);
8        }
9        int c=0;
10        for(char i:a1){
11            if(word.contains(String.valueOf(i).toLowerCase()))
12            c++;
13        }
14        return c;
15    }
16}