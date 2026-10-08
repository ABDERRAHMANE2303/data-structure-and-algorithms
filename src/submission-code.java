class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        return !(nums.length  ==  numsSet.size());
    }
}