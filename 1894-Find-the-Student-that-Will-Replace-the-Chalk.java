class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long s=0;
            for(int i=0;i<chalk.length;i++){
                s+=chalk[i];
            }
            k%=s;
            for(int i=0;i<chalk.length;i++){
                if(chalk[i]>k)
                return i;
                k-=chalk[i];
            }
        return 0;
    }
}