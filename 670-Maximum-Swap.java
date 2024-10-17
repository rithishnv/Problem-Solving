class Solution {
    public int maximumSwap(int num) {
        ArrayList<Integer> li=new ArrayList<>();
        int max=num;
        while(num>0){
            li.add(num%10);
            num/=10;
        }
        Collections.reverse(li);
        for(int i=0;i<li.size();i++){
            for(int j=i;j<li.size();j++){
                if(li.get(i)<li.get(j)){
                    ArrayList<Integer> li1=(ArrayList)li.clone();
                    li1.set(i,li.get(j));
                    li1.set(j,li.get(i));
                    int y=0;
                    for(int k:li1)
                    y=y*10+k;
                    max=Math.max(max,y);
                }
            }
        }
        return max;
    }
}