class Solution {
    public long countGoodIntegers(int n, int k) {
        int hlen=(n+1)/2;
        int minlen=(int) Math.pow(10,hlen-1);
        int maxlen=(int) Math.pow(10,hlen);
        long ans=0;
        Set<String> vis=new HashSet<>();
        for(int num=minlen;num<maxlen;num++){
            String first=String.valueOf(num);
            String sec=new StringBuilder(first).reverse().toString();
            String fin=first+sec.substring(n%2);
            if(Long.parseLong(fin)%k!=0)
            continue;
            char[] digit=fin.toCharArray();
            Arrays.sort(digit);
            String digstr=new String(digit);
            if(vis.contains(digstr))
            continue;
            vis.add(digstr);
            int[] digfre=new int[10];
            for(char i:fin.toCharArray())
            digfre[i-'0']++;
            int firschoice=n-digfre[0];
            long permutation=firschoice*factorial(n-1);
            for(int fre:digfre){
                permutation/=factorial(fre);  
            }
            ans+=permutation;
        }
        // System.out.println(maxlen+" "+minlen);
        return ans;
    }
    public long factorial(int n){
        long res=1;
        for(int i=2;i<=n;i++){
            res*=i;
        }
        return res;
    }
}