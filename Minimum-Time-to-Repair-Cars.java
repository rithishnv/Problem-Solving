class Solution {
    public long repairCars(int[] ranks, int cars) {
        long i=0;
        long j=0;
        long max=0;
        for(int k:ranks){
            max=Math.max(max,k);
        }
        j=max*cars*cars;
        long res=0;
        while(i<=j){
          long m=i+(j-i)/2;
          if(isValid(ranks,cars,m)){
            res=m;
            j=m-1;
          }  
          else
          i=m+1;
        }
        return res;
    }
    public boolean isValid(int[] ranks,int cars,long m){
        long tot=0;
        for(int i:ranks){
            tot+=(long)Math.sqrt(m/i);
            if(tot>=cars)
            return true;
        }
        return tot>=cars;
    }
}