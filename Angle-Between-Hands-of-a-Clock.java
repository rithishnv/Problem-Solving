1class Solution {
2    public double angleClock(int hour, int minutes) {
3        double hourAngle = (hour % 12) * 30 + minutes * 0.5;
4        double minute = minutes * 6;
5        double diff = Math.abs(hourAngle - minute);
6        return Math.min(diff, 360 - diff);
7    }
8}