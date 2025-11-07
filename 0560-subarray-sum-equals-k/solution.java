import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1); 
        
        int currentSum = 0;
        int count = 0;
        
        for (int num : nums) {
            currentSum += num;
            
            
            if (sumCount.containsKey(currentSum - k)) {
                count += sumCount.get(currentSum - k);
            }
            
            
            sumCount.put(currentSum, sumCount.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}

