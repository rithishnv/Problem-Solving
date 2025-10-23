class Solution {
    public boolean hasSameDigits(String s) {
        List<Integer> li=new ArrayList<Integer>();
        for(char i:s.toCharArray()){
            li.add(i-'0');
        }
        while(li.size()!=2){
            for(int i=0;i<li.size()-1;i++){
                li.set(i,(li.get(i)+li.get(i+1))%10);
            }
            li.remove(li.size()-1);
        }
        return li.get(0)==li.get(1);
    }
}