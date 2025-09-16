class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> li=new ArrayList<>();
        for(int i:nums){
            while(true){
                int last=(li.isEmpty())?1:li.getLast();
                int s=gcd(last,i);
                if(s==1)
                break;
                i*=li.removeLast()/s;
            }
            li.add(i);
        }
        return li;
    }
    public int gcd(int a,int b){
        return b>0 ? gcd(b,a%b):a;
    }
}