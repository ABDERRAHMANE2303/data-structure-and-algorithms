class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> nums_set = new HashSet<>();
        for (int element : nums){
            nums_set.add(element);
        }
        int max_count = 0 , seq_count =0;
        for (int i = 0 ; i<nums.length ; i++){
            if (!nums_set.contains(nums[i]-1)){
                int current = nums[i];
                seq_count++;
                while (nums_set.contains(current+1)) {
                    seq_count++;
                    current ++;
                }
            }
            if (max_count < seq_count) max_count = seq_count;
            seq_count =0;
        }
        return max_count;
    }
}

