class Solution {
    public int[] plusOne(int[] digits) {
        int number =0;
        for (int i=0 ; i<digits.length ; i++){
            number += digits[i] * Math.pow(10,digits.length - i -1);
        }

        number +=1;
        
        int digits_count = number == 0 ? 1 : (int) Math.log10(number) + 1; 
        int[] out = new int[digits_count];
        for (int i=0 ; i< digits_count; i++){
            out[i] = (int) (number / Math.pow(10,digits_count - i -1));
            number -= out [i] * Math.pow(10,digits_count -i -1);
        }

        return out;
        
    }
}

