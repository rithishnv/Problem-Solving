class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res=new ArrayList<>();
        for(int i=1;i<=9;i++){
            dfs(i,i,res,low,high);
        }
        Collections.sort(res);
        return res;
    }
    public void dfs(int j,int num,List<Integer> li,int low,int high){
        if(num>high || j>9){
            return;
        }
        if(num>=low){
            li.add(num);
        }
        dfs(j+1,(num*10)+(j+1),li,low,high);
        return;
    }
}