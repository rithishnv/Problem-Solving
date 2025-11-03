class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res=0;
        // PriorityQueue<Integer> pq=new PriorityQueue<>();
        int s=0,max=0;
        for(int i=0;i<colors.length()-1;i++){
            int j=i+1;
            s=neededTime[i];
            max=neededTime[i];
            while(j<colors.length()&&colors.charAt(i)==colors.charAt(j)){
                s+=neededTime[j];
                max=Math.max(neededTime[j],max);
                j++;
            }
            if(i!=j){
            res+=(s-max);
            i=j-1;
            }
        }
        return res;
    }
}