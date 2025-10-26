class Bank {

    long[] acc;
    int n;
    public Bank(long[] balance) {
        acc=balance;
        n=balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1-1 >=n || account2-1 >=n || acc[account1-1]<money)
        return false;
        acc[account1-1]-=money;
        acc[account2-1]+=money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(account-1 >=n)
        return false;
        acc[account-1]+=money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
         if(account-1 >=n || acc[account-1]<money)
        return false;
        acc[account-1]-=money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */