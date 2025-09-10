class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> set=new HashSet<>();
        for(int[] i:friendships){
            int p1=i[0]-1;
            int p2=i[1]-1;
            boolean comm=false;
            for(int j:languages[p1]){
                for(int k:languages[p2]){
                    if(j==k){
                        comm=true;
                        break;
                    }
                }
                if(comm)
                break;
            }
            if(!comm){
            set.add(p1);
            set.add(p2);
        }
        }
        int res=languages.length+1;
        for(int i=1;i<=n;i++){
            int cnt=0;
            for(int user:set){
                boolean know=false;
                for(int l:languages[user]){
                    if(l==i){
                        know=true;
                        break;
                    }
                }
                if(!know)
                cnt++;
            }
            res=Math.min(cnt,res);
        }
        return res;
    }
}