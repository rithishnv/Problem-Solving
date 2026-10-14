class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        while(num-- > 0) {
            sb.append((char) (Math.min(9, sum) + '0'));
            sum -= Math.min(9, sum);
        }
        return sum > 0 ? "" : sb.toString();
    }
}