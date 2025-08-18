class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> li=new ArrayList<>();
        for(int i:cards){
            li.add((double)i); 
        }
        return dfs(li);
    }
    public boolean dfs(List<Double> li){
        if(li.size()==1){
            return Math.abs(li.get(0)-24.0)<0.0001;
        }
        int n=li.size();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)
                continue;
                List<Double> nxt=new ArrayList<>();
                for(int k=0;k<n;k++){
                    if(k!=i && k!=j)
                    nxt.add(li.get(k));
                }
                List<Double> res=new ArrayList<>();
                double a=li.get(i),b=li.get(j);
                res.add(a+b);
                res.add(a-b);
                res.add(b-a);
                res.add(a*b);
                res.add(a/b);
                res.add(b/a);
                for(double v:res){
                    nxt.add(v);
                    if(dfs(nxt))
                    return true;
                    nxt.remove(nxt.size()-1);
                }

            }
        }
        return false;
    }
}