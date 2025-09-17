class FoodRatings {

    class Food{
        String name;
        String cuisine;
        int rating;

        public Food(String name,String cuisine,int rating){
            this.name=name;
            this.cuisine=cuisine;
            this.rating=rating;
        }
    }

    Map<String,Food> map;
    Map<String,PriorityQueue<Food>> cuMap;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map=new HashMap<>();
        cuMap=new HashMap<>();
        for(int i=0;i<foods.length;i++){
            Food fd=new Food(foods[i],cuisines[i],ratings[i]);
            map.put(foods[i],fd);
            if(!cuMap.containsKey(cuisines[i]))
            cuMap.put(cuisines[i],new PriorityQueue<>((a,b)->a.rating==b.rating?a.name.compareTo(b.name):b.rating-a.rating));
            cuMap.get(cuisines[i]).offer(fd);
        }
    }
    
    public void changeRating(String food, int newRating) {
        map.get(food).rating=newRating;
        PriorityQueue<Food> pq=cuMap.get(map.get(food).cuisine);
        pq.remove(map.get(food));
        pq.add(map.get(food));
    }
    
    public String highestRated(String cuisine) {
        return cuMap.get(cuisine).peek().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */