class Solution {
    public boolean isVowel(char s){
        if(s=='a'||s=='e'||s=='i'||s=='o'||s=='u'||s=='A'||s=='E'||s=='I'||s=='O'||s=='U')
        return true;
        else
        return false;
    }
    public String sortVowels(String s) {
        List<Character> li=new ArrayList<>();
        for(char i:s.toCharArray()){
            if(isVowel(i))
            li.add(i);
        }
        Collections.sort(li);
        StringBuilder sb=new StringBuilder();
        int j=0;
        for(char i:s.toCharArray()){
            if(isVowel(i))
            sb.append(li.get(j++));
            else
            sb.append(i);
        }
        return sb.toString();
    }
}