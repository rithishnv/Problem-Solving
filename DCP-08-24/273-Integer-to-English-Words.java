class Solution {
    String[] ones=new String[]{"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] tens=new String[]{"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        String r="";
        if(num==0)
        return "Zero";
        else
        return numberToWords1(num);
    }
     public String numberToWords1(int num){
        String r="";
        if(num<20){
            r=ones[num];
        }
        else if(num<100){
            r=tens[num/10]+" "+numberToWords1(num%10);
        }
        else if(num<1000){
            r=ones[num/100]+" Hundred "+numberToWords1(num%100);
        }
        else if(num<1000000){
            r=numberToWords1(num/1000)+" Thousand "+numberToWords1(num%1000);
        }
        else if(num<1000000000){
        r=numberToWords1(num/1000000)+" Million "+numberToWords1(num%1000000);
        }
        else {
        r=numberToWords1(num/1000000000)+" Billion "+numberToWords1(num%1000000000);
        }
        return r.strip();
    }
}