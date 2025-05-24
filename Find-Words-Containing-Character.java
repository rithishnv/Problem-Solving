class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> li=new ArrayList<>();
        String j=String.valueOf(x);
        for(int i=0;i<words.length;i++){
            if(words[i].contains(j))
            li.add(i);
        }
        return li;
    }
}