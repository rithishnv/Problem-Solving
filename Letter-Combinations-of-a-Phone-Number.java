class Solution {
    List<String> li=new ArrayList<>();
    void com(String s,Map<Character,String[]> map,int i,StringBuilder sb){
        if(i==s.length()){
            li.add(new String(sb.toString()));
            return;
        }
            for(String l:map.get(s.charAt(i))){
            sb.append(l);
            com(s,map,i+1,sb);
            sb.deleteCharAt(sb.length()-1);
            }
        return;
    }
    public List<String> letterCombinations(String digits) {
        Map<Character,String[]> map=new HashMap<>();
        map.put('2',new String[]{\a\,\b\,\c\});
        map.put('3',new String[]{\d\,\e\,\f\});
        map.put('4',new String[]{\g\,\h\,\i\});
        map.put('5',new String[]{\j\,\k\,\l\});
        map.put('6',new String[]{\m\,\n\,\o\});
        map.put('7',new String[]{\p\,\q\,\r\,\s\});
        map.put('8',new String[]{\t\,\u\,\v\});
        map.put('9',new String[]{\w\,\x\,\y\,\z\});
        if(digits.length()==0)
        return li;
        com(digits,map,0,new StringBuilder());
        return li;
    }
}