class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        List<String> li=new ArrayList<>();
        for(String i:text.split(" ")){
            li.add(i);
        }
        if(brokenLetters.length()==0)
        return li.size();
        for(String i:brokenLetters.split("")){
            List<String> l=new ArrayList<>(li);
            for(String j:li){
                if(j.contains(i))
                l.remove(j);
            }
            li=l;
        }
        return li.size();
    }
}