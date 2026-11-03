class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length -1 ; i>=0 ; i--){
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] out = new int[digits.length+1];
        out[0] = 1;
        for (int i=1;i<digits.length+1;i++){
            out[i] = 0;
        }
        return out;
    }
}

