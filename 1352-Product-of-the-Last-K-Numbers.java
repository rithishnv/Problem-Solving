class ProductOfNumbers {
    ArrayList<Integer> li;
    public ProductOfNumbers() {
        li=new ArrayList<Integer>();
        li.add(1);
    }
    
    public void add(int num) {  
        if(num==0){
        li.clear();
        li.add(1);
        }
        else{
            li.add(num*li.get(li.size()-1));
        }
    }
    
    public int getProduct(int k) {
        int s=li.size();
        if(s<=k)
        return 0;
        return li.get(s-1)/li.get(s-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */