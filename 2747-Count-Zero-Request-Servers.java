class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m=queries.length;
        int[] res=new int[m];
        Arrays.sort(logs,(a,b)->Integer.compare(a[1],b[1]));
        Map<Integer,Integer> map=new HashMap<>();
        Integer[] idx=new Integer[m];
        for(int i=0;i<m;i++){
            idx[i]=i;
        }
        Arrays.sort(idx,(a,b)->Integer.compare(queries[a],queries[b]));
        int l=0;
        int r=0;
        int active=0;
        for(int i:idx){
            int s=queries[i]-x;
            int e=queries[i];
            while(r<logs.length && logs[r][1]<=e){
                int server=logs[r][0];
                map.put(server,map.getOrDefault(server,0)+1);
                if(map.get(server)==1)
                    active++;
                r++;
            }
            while(l<r && logs[l][1]<s){
                int server=logs[l][0];
                map.put(server,map.get(server)-1);
                if(map.get(server)==0){
                    map.remove(server);
                    active--;
                }
                l++;
            }
            res[i]=n-active;
        }
        return res;
    }
}