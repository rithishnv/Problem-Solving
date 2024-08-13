class Solution {
    List<List<Integer>> li=new ArrayList<List<Integer>>();
    public void check(int i,int[] a,List<Integer> li1,int t){
        if(t<0)
        return;
        if(t==0){
            li.add(new ArrayList<Integer>(li1));
            return;
        }
        for(int j=i;j<a.length;j++){
            li1.add(a[j]);
            check(j,a,li1,t-a[j]);
            li1.remove(li1.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        check(0,candidates,new ArrayList<Integer>(),target);
        return li;
        
    }
}