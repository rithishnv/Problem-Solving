class Solution {
    HashSet<String> set=new HashSet<>();
    boolean[] v;
    void check(int ind,String tiles,String s){
        if(s.length()==tiles.length()){
            return;
        }
        for(int i=0;i<tiles.length();i++){
            StringBuilder sb=new StringBuilder(s);
            if(v[i])
            continue;
            v[i]=true;
            sb.append(tiles.charAt(i));
            set.add(sb.toString());
            check(ind,tiles,sb.toString());
            sb.deleteCharAt(sb.length()-1);
            v[i]=false;
        }
        return;
    }
    public int numTilePossibilities(String tiles) {
        v=new boolean[tiles.length()];
        check(0,tiles,"");
        return set.size();
    }
}