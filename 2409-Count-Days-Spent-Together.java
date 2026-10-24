class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {31 , 28 , 31 , 30 , 31 , 30 , 31 , 31 , 30 , 31 , 30 , 31};
        int a1 = check(arriveAlice , days);
        int a2 = check(leaveAlice , days);
        int b1 = check(arriveBob , days) ;
        int b2 = check(leaveBob , days);
        int start = Math.max(a1 , b1);
        int end = Math.min(a2 , b2);
        if(start > end){
            return 0 ;
        }
        return end - start + 1;
    }
    public int check(String date , int[] days){
        String[] arr = date.split("-");
        int month = Integer.parseInt(arr[0]);
        int d=Integer.parseInt(arr[1]);
        int s=0;
        for(int i = 0 ; i < month-1 ; i++){
            s+= days[i];
        }
        return s+d;        
    }
}