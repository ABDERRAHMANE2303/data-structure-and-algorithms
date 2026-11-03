class Solution {
    public int search(int[] nums, int target) {
        int upper_bound = nums.length; 
        int lower_bound = 0;
        int middle = upper_bound / 2; 

        while (upper_bound != lower_bound) {

            if (nums[middle] == target){
                return middle;
            }else if (nums[middle] > target){
                upper_bound = middle;
            }else {
                lower_bound = middle+1;
            }
            middle  =  (upper_bound + lower_bound) / 2 ;
        }
        return -1;
    }
}
