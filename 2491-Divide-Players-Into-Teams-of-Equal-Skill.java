class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long check=skill[skill.length-1]+skill[0];
        int i=0,j=skill.length-1;
        long sum=0;
        while(i<j){
            if((skill[j]+skill[i])!=check)
            return -1;
            sum+=(skill[i++]*skill[j--]);
        }
        return sum;
    }
}