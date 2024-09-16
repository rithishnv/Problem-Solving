class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int min=Integer.MAX_VALUE;
         String[] a=timePoints.get(0).split(":");
         int first=Integer.valueOf(a[0])*60+Integer.valueOf(a[1]);
         int c=first;
        for(int i=1;i<timePoints.size();i++){
            String[] a1=timePoints.get(i).split(":");
            int p = Integer.valueOf(a1[0])*60+Integer.valueOf(a1[1]);
            min=Math.min(min,p-c);
            c=p;
        }
        String[] a1=timePoints.get(timePoints.size()-1).split(":");
        int d=Integer.valueOf(a1[0])*60+Integer.valueOf(a1[1]);
        min=Math.min(min,24*60-d+first);
        return min;
    }
}