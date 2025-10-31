class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> sum = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < nums.length; i++){
            if(sum.containsKey(target - nums[i])){
                return new int[]{sum.get(target - nums[i]), i};
            }
            sum.put(nums[i], i);
        }
        return new int[]{};
    }
}
