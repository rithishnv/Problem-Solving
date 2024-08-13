class Solution {
    public int minDeletions(String s) {
        List<Integer> li=new ArrayList<>();
        char[] a=s.toCharArray();
        Arrays.sort(a);
        for(int i=0;i<a.length;i++){
            int c=1;
            while(i+1<a.length&& a[i]==a[i+1]){
                c++;
                i++;
            }
            li.add(c);
        }
        Collections.sort(li,Collections.reverseOrder());
        int c=0;
        Set<Integer> set=new HashSet<>();
        for(int i:li){
            while(i>0&&!set.add(i)){
                i--;
                c++;
            }
        }
        return c;
    }
}