class Solution {
    public int minimumSum(int n, int k) {
        Set<Integer> li=new HashSet<>();
        int i=1,s=0;
        while(li.size()<n){
            if(!li.contains(k-i)){
                li.add(i);
                s+=i;
            }
            i++;
        }
        return s;
    }
}