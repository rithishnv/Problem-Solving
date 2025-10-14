class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> li, int k) {
      int len=k;
      k=k-1;
      if(k==0)
      return true;
      for(int i=len+1;i<li.size();i++){
        if(li.get(i-1)<li.get(i) && li.get(i-len-1)<li.get(i-len)){
            k--;
        }
        else{
            k=len-1;
        }
        if(k==0)
        return true;
      }
      return false;
    }
}