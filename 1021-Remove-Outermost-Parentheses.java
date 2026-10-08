class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int t = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (t > 0){
                    res.append(c);
                }
                t++;
            } 
            else {
                t--;
                if (t > 0){
                    res.append(c);
                }
            }
        }
        return res.toString();
    }
}