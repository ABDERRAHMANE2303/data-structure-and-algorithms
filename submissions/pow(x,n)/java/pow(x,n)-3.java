class Solution {
    public double myPow(double x, int n) {
        return longPow(x,(long) n);   
    }

    public double longPow(double x, long n){
        if (n==0)return 1;

        long half = (n >0) ? n/2 : -n/2 ;
        double base = longPow(x,half);

        if (n>0) {
            return (n%2==0? 1:x) * base * base;
        }
        else {
            return 1/((n%2==0? 1:x) * base * base);
        }
    }
}



