1class Solution {
2    public String makeLargestSpecial(String s) {
3         int count = 0, i = 0;
4        List<String> res = new ArrayList<String>();
5        for (int j = 0; j < s.length(); ++j) {
6          if (s.charAt(j) == '1') count++;
7          else count--;
8          if (count == 0) {
9            res.add('1' + makeLargestSpecial(s.substring(i + 1, j)) + '0');
10            i = j + 1;
11          }
12        }
13        Collections.sort(res, Collections.reverseOrder());
14        return String.join("", res);
15    }
16}