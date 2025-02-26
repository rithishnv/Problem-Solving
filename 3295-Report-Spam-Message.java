class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> a1 = new HashSet<>();
        for (String word : bannedWords) {
            a1.add(word);
        }
        int c=0;
        for(String i:message){
            if(a1.contains(i))
            c++;
             if(c>=2)
            return true;
        }
        return false;
    }
}