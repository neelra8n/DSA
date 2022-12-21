/**
 *   Solution 1 
 *   brute force
 *   TC - O(n2+n+n), SC - O(n);
 *   flag duplicate values
 *   store uniqe elements in temp array 
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(nums[i] == nums[j]) nums[j] = -102;
            }
        }

        int[] temp = new int[n];
        int k = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] != -102){
                temp[k++] = nums[i];
            }
        }
        for(int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
        return k;
        }
}


/**     
 * Solution 2
 * Optimal solution 
 * TC - O(n), SC - O(1) 
 * flag duplicates 
 * store unique elements in nums
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        for(int i = 1; i < n; i++) {
            int curr = nums[i-1];
            while(i < n && nums[i] == curr) {
                nums[i] = 105;
                i++;
            }
        }  
        int k = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] != 105) {
                nums[k++] = nums[i]; 
            }
        } 
        return k;
    }
}
