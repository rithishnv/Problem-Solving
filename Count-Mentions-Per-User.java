1class Solution {
2    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
3        Collections.sort(events, (a,b)-> {
4            int x = Integer.parseInt(a.get(1));
5            int y = Integer.parseInt(b.get(1));
6            int m1 = a.get(0).equals("OFFLINE") ? 0 : 1;
7            int m2 = b.get(0).equals("OFFLINE") ? 0 : 1;
8            return x==y ? m1-m2 : x-y; }
9        );
10
11        int[] ans = new int[numberOfUsers];   
12        int[] online = new int[numberOfUsers];
13        int allCount = 0;    
14
15        for(List<String> event : events){
16            String type = event.get(0);
17            if(type.equals("MESSAGE")){
18                int time=Integer.parseInt(event.get(1));
19
20                String mention = event.get(2);
21                if(mention.equals("ALL")){
22                    for(int i=0; i<numberOfUsers; i++) ans[i]++;
23                }
24                else if(mention.equals("HERE")){
25                    for(int i=0; i<numberOfUsers; i++){
26                        if(time>=online[i]) ans[i]++;
27                    }
28                }
29                else{
30                    String[] users = mention.split(" ");
31                    for(String user : users){
32                        int id = Integer.parseInt(user.substring(2,user.length()));
33                        ans[id]++;
34                    }
35                }
36            }
37
38            else{
39                int id = Integer.parseInt(event.get(2));
40                int time = Integer.parseInt(event.get(1));
41                online[id]=time+60;
42            }
43        }
44
45        return ans;
46    }
47}