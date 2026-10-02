class Solution {
    public List<String> generateParenthesis(int n) {
        if (n-- == 1) return List.of("()");
        check(n, n, "(");
        return res;
    }
    List<String> res = new ArrayList<>();
    public void check(int O, int C, String s) {
        if (O == 0 && C == 0) {
            res.add(s + ")");
            return;
        }
        if (O > 0)
            check(O - 1, C, s + "(");
        if (C >= O)
            check(O, C - 1, s + ")");
    }
}