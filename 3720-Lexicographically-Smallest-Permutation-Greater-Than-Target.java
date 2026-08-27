class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        for (int i = n - 1; i >= 0; i--) {
            int[] temp = freq.clone();
            boolean ok = true;

            for (int j = 0; j < i; j++) {
                if (temp[target.charAt(j) - 'a'] == 0) {
                    ok = false;
                    break;
                }
                temp[target.charAt(j) - 'a']--;
            }

            if (!ok) continue;

            int chosen = -1;
            for (int c = target.charAt(i) - 'a' + 1; c < 26; c++) {
                if (temp[c] > 0) {
                    chosen = c;
                    break;
                }
            }

            if (chosen == -1) continue;

            temp[chosen]--;
            StringBuilder suffix = new StringBuilder();
            for (int c = 0; c < 26; c++) {
                for (int k = 0; k < temp[c]; k++) {
                    suffix.append((char)('a' + c));
                }
            }

            return target.substring(0, i) + (char)('a' + chosen) + suffix.toString();
        }

        return "";
    }
}