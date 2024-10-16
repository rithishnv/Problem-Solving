class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->y[1]-x[1]);
        pq.add(new int[]{0,a});
        pq.add(new int[]{1,b});
        pq.add(new int[]{2,c});
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            int[] s=pq.poll();
            if(sb.length()>=2 &&sb.charAt(sb.length()-1)==(s[0]+'a') &&sb.charAt(sb.length()-2)==(s[0]+'a')){
                if(pq.isEmpty())
                break;
                int[] s1=pq.poll();
                if(s1[1]>0)
                sb.append((char)(s1[0]+'a'));
                s1[1]--;
                if(s1[1]>0)
                pq.add(s1);
                pq.add(s);
            }
            else{
                if(s[1]>0)
                sb.append((char)(s[0]+'a'));
                s[1]--;
                if(s[1]>0)
                pq.add(s);
            }
        }
        return sb.toString();
    }
}