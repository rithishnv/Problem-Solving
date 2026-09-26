class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map=new HashMap<>();
        StringBuilder res=new StringBuilder();
        int n=s.length();
        int i=0;
        for(List<String> li:knowledge){
            map.put(li.get(0),li.get(1));
        }
        while(i<n){
            if(s.charAt(i)=='('){
                i++;
                StringBuilder sb=new StringBuilder();
                while(s.charAt(i)!=')'){
                    sb.append(s.charAt(i++));
                }
                res.append(map.getOrDefault(sb.toString(),"?"));
                i++;
                continue;
            }
            res.append(s.charAt(i++));
        }
        return res.toString();
    }
}