// leetcode - findAllDuplicatesinAnArray#442

/**
    Solution 1
        TC - O(n2)
        SC - O(1)
        use two loops

    Solution 2
        TC - O(nlogn+n)
        SC - O(n)
        sort the array
    
    Solution 3
        TC - O(n)
        SC - O(n) 
        use hashmap or frequency array

    Solution 4
        TC - O(n)
        SC - O(1)
        - use same array as frequency array,
        - we know that the elements can appear atmost twice,
        - using -ve sign as flag/count,
        - mark "nums[Math.abs(nums[i])-1]"(0 based indexing) as -ve,
        - keep checking if the converted element is +ve
        - if any -ve element is converted back to +ve, add the "index(nums[i])" in the list.
        - * this approach gives you solution to two different questions.
        - * 1. finding duplicates in an array with range (1-n) &
        - * 2. finding missing elements in an array with range (1-n)
*/ 
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length, positiveCount = 0;
        for (int i = 0; i < n; i++) {
            nums[Math.abs(nums[i])-1] = - nums[Math.abs(nums[i])-1];
            if(nums[Math.abs(nums[i])-1] > 0) list.add(Math.abs(nums[i]));
        }
        return list;                                                                        
    }
}