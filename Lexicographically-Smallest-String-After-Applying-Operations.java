class Solution {
    Set<String> set;
    String smallest;
    
    public String findLexSmallestString(String s, int a, int b) {
        set = new HashSet<>();    
        smallest = s;
        
        helper(s, a, b);
        
        return smallest;
    }
    
    void helper(String s, int a, int b) {
        if(set.contains(s)) {
            return;
        }
        
        if(s.compareTo(smallest) < 0) {
            smallest = s;
        }
        
        set.add(s);
        
        helper(rotate(s, b), a, b);
        helper(add(s, a), a, b);
    }
    
    String rotate(String s, int pos) {
        int len = s.length() - pos;
        return s.substring(len) + s.substring(0, len);
    }
    
    String add(String s, int a) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(i % 2 == 1) {
                int sum = ((c-'0') + a) % 10;
                c = (char) (sum + 48);
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
}