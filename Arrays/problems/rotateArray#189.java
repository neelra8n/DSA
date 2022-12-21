// LeetCode #189

    // Solution 1
    // missing edge case -> if k > n;
    // array rotated any times more n will be same as "rotation % n";
    // TC - O(n), SC - O(n);

    // PSEUDO CODE
    // create a temp arr of same size
    // ans[i] = nums[(n+i-k)%n] 
    // (n+i-k)%n -> takes care of rotation of k times and 
    // map it from(wrt i) zero for temp array to be stored
    // restore in nums;

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        int[] ans = new int[n];
        for (int i = 0; i < k; i++) {
            ans[i] = nums[(n+i-k)%n];
        }
        for (int i = k; i < n; i++) {
            ans[i] = nums[i-k];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = ans[i];
        }
        
    }
}



    // Solution 2
    
    // TC - O(n) , SC - O(1);
    // reverse whole array
    // reverse 0-(k-1) of array
    // reverse k-(n-1) of array

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
        System.out.print(Arrays.toString(nums));

    }
    // part of Solution 2
    public void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}