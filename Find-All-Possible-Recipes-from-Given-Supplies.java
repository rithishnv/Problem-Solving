class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
     int n=recipes.length;
     List<String> li=new ArrayList<>();
     Set<String> set=new HashSet<>();
     for(String i:supplies){
        set.add(i);
     }
     while(n-->0){
        for(int i=0;i<recipes.length;i++){
            if(li.contains(recipes[i]))
            continue;
            boolean p=true;
            for(String j:ingredients.get(i)){
                if(!set.contains(j))
                p=false;
            }
        if(p){
        li.add(recipes[i]);
        set.add(recipes[i]);
        }
        }
     }
     return li;
    }
}