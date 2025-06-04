class Solution {
    // // List<String> li=new ArrayList<>();
    // String st="";
    // public boolean check(String word,int n,int ind,int t){
    //     // if(n==t){
    //     //     // li.add(word.substring(ind));
    //     //     st=(st.compareTo(word.substring(ind))>=0)?st:word.substring(ind);
    //     //     return true;
    //     // }
    //     for(int i=ind;i<word.length();i++){
    //         if(word.length()-i-1>n-i-1){
    //         // check(word,n,i+1,t+1);
    //         st=(st.compareTo(word.substring(ind,i+1))>=0)?st:word.substring(ind,i+1);
    //         // li.add(word.substring(ind,i+1));/
    //         }
            
    //     }
    //     return false;
    // }
    public String answerString(String word, int numFriends) {
        if(numFriends==1)
        return word;
        String st="";
    int n=word.length();
    int min=n-numFriends+1;
    for(int i=0;i<n;i++){
        String s=word.substring(i,Math.min(i+min,n));
        // if(i+min<=n)
        // s=word.substring(i,Math.min(i+min,n));;
        // else
        // s=word.substring(i);
        if(s.compareTo(st)>0)
        st=s;
    }
    return st; 
    }
}