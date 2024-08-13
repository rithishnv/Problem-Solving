class Solution {
    public void path(int i, int[] a,int t,List<List<Integer>> li,List<Integer> li1){
        if(t<0)
        return;
        if(t==0){
        li.add(new ArrayList<>(li1));
        return;
        }
        for(int j=i;j<a.length;j++){
            if(j>i && a[j]==a[j-1])
            continue;
            li1.add(a[j]);   
            path(j+1,a,t-a[j],li,li1);
            li1.remove(li1.size()-1);
        }
        return;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> li=new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        path(0,candidates,target,li,new ArrayList<Integer>());
        return li;
    }
}