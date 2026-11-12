class Solution {
    public double myPow(double x, int n) {
        return longPow(x,(long) n);
            
    }
    
    public double longPow(double x, long n){
        if (n==0)return 1;
        if (n==1) return x;

        long half = (n >0) ? n/2 : -n/2 ;
        double base = longPow(x,half);

        if (n>0) {
            return longPow(x,n%2) * base * base;
        }
        else {
            return 1/(longPow(x,-n%2) * base * base);
        }
    }
}



