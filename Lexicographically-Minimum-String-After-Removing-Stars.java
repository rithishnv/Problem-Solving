class Solution {
    public String clearStars(String s) {
        Map<Character,Deque<Integer>> map=new HashMap<>();
        PriorityQueue<Character> pq=new PriorityQueue<>();
        boolean[] arr=new boolean[s.length()];
        Arrays.fill(arr,true);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                char t=pq.poll();
                int ind=map.get(t).removeLast();
                arr[ind]=false;
                arr[i]=false;
            }
            else{
                char a=s.charAt(i);
                Deque<Integer> l=map.getOrDefault(a,new ArrayDeque<Integer>());
                l.add(i);
                pq.add(a);
                map.put(a,l);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(arr[i])
            sb.append(s.charAt(i));
        }
        // System.out.println(pq);
        // System.out.println(map);
        // System.out.println(li);
        return sb.toString();
    }
}