class Solution {
    public void elem(int t,List<Integer> li,int n){
        if(t>n)
        return;
        li.add(t);
        for(int i=0;i<=9;i++){
            elem((t*10)+i,li,n);
        }
    }
    public List<Integer> lexicalOrder(int n) {
         List<Integer> li=new ArrayList<>();
        for(int i=1;i<=9;i++){
            elem(i,li,n);
        }
        return li;
    }
}