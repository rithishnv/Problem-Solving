class NumberContainers {
    HashMap<Integer,PriorityQueue<Integer>> map;
    HashMap<Integer,Integer> map1;
    public NumberContainers() {
        map=new HashMap<>();
        map1=new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(map1.containsKey(index)){
            int m=map1.get(index);
            if(m==number)
            return;
            PriorityQueue<Integer> q=map.get(m);
            q.remove(index);
            if(q.size()==0)
            map.remove(m);
            else
            map.put(m,q);
        }
        PriorityQueue<Integer> q=map.getOrDefault(number,new PriorityQueue<>());
        q.add(index);
        map.put(number,q);
        map1.put(index,number);
    }
    
    public int find(int number) {
        if(map.containsKey(number)){
            return map.get(number).peek();
        }
        else
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */