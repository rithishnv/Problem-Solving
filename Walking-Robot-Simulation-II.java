1class Robot {
2    int m,n,tot,curr;
3    int dirs[];
4    Map<Integer,int[]> vals;
5    Map<Integer,Integer> dir;
6    boolean notstarted;
7
8    public Robot(int width, int height) {
9        n=width;
10        m=height;
11        curr=0;
12        notstarted=true;
13        dirs=new int[]{0,1,0,-1,0};
14        vals=new HashMap<>();
15        dir=new HashMap<>();
16        tot=0;
17        int d=0;
18        int tempx=0,tempy=0;
19        do{
20            vals.put(tot,new int[]{tempy,tempx});
21            dir.put(tot,d);
22            tot++;
23            tempx=tempx+dirs[d];tempy=tempy+dirs[d+1];
24            if(tempx<0||tempy<0||tempx>=m||tempy>=n){
25                tempx=tempx-dirs[d];tempy=tempy-dirs[d+1];
26                d++;
27                d=d%4;
28                tempx=tempx+dirs[d];tempy=tempy+dirs[d+1];
29            }
30        }while(tempx!=0||tempy!=0);
31    }
32    
33    public void step(int num) {
34        curr=curr+num;
35        curr%=tot;
36        notstarted=false;
37    }
38    
39    public int[] getPos() {
40        return vals.get(curr);
41    }
42    
43    public String getDir() {
44        int i=dir.get(curr);
45        if(i==0&&(notstarted||curr!=0)) return "East";
46        else if(i==1) return "North";
47        else if(i==2) return "West";
48        else return "South";
49    }
50}
51
52/**
53 * Your Robot object will be instantiated and called as such:
54 * Robot obj = new Robot(width, height);
55 * obj.step(num);
56 * int[] param_2 = obj.getPos();
57 * String param_3 = obj.getDir();
58 */