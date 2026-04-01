1class Solution {
2    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
3        int n = positions.length;
4
5        Integer[] idx = new Integer[n];
6        for (int i = 0; i < n; i++) idx[i] = i;
7
8        
9        Arrays.sort(idx, (a, b) -> positions[a] - positions[b]);
10
11        Stack<Integer> st = new Stack<>();
12
13        for (int id : idx) {
14            if (directions.charAt(id) == 'R') {
15                st.push(id);
16            } else {
17                
18                while (!st.isEmpty() && directions.charAt(st.peek()) == 'R' && healths[id] > 0) {
19                    int top = st.peek();
20
21                    if (healths[top] < healths[id]) {
22                        st.pop();
23                        healths[id]--;
24                    } 
25                    else if (healths[top] > healths[id]) {
26                        healths[top]--;
27                        healths[id] = 0;
28                    } 
29                    else {
30                        st.pop();
31                        healths[id] = 0;
32                    }
33                }
34
35                if (healths[id] > 0) {
36                    st.push(id);
37                }
38            }
39        }
40
41       
42        List<int[]> survivors = new ArrayList<>();
43        while (!st.isEmpty()) {
44            int id = st.pop();
45            survivors.add(new int[]{id, healths[id]});
46        }
47
48        
49        Collections.sort(survivors, (a, b) -> a[0] - b[0]);
50
51        List<Integer> ans = new ArrayList<>();
52        for (int[] p : survivors) {
53            ans.add(p[1]);
54        }
55
56        return ans;
57    }
58}