class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<colors.length()-1;i++){
            int j=i+1;
            pq.add(neededTime[i]);
            while(j<colors.length()&&colors.charAt(i)==colors.charAt(j)){
                pq.add(neededTime[j]);
                j++;
            }
            while(pq.size()>1){
                res+=pq.poll();
                i=j-1;
            }
            pq.clear();
        }
        return res;
    }
}