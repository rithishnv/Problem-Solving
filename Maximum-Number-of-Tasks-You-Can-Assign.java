class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int l=0,r=Math.min(tasks.length,workers.length);
        while(l<r){
            int mid=(l+r+1)/2;
            if(assign(tasks,workers,pills,strength,mid))
            l=mid;
            else
            r=mid-1;
        }
        return l;
    }
    boolean assign(int[] tasks, int[] workers, int pills, int strength,int mid){
        Deque<Integer> boost=new ArrayDeque<>();
        int w=workers.length-1;
        int a=pills;
        for(int t=mid-1;t>=0;t--){
            int task=tasks[t];
            if(!boost.isEmpty() && boost.peekFirst()>=task){
                boost.pollFirst();
            }
            else if(w>=0 && workers[w]>=task){
                w--;
            }
            else{
                while(w>=0 && workers[w]+strength>=task){
                    boost.addLast(workers[w--]);
                }
                if(boost.isEmpty() || a==0){
                return false;
                }
                boost.pollLast();
                a--;
            }
        }
        return true;
    } 
}