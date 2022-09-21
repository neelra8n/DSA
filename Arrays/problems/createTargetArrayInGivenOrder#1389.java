/*package Arrays.problems;

/**
 * createTargetArrayInGivenOrder#1389
 * 
 *   Solution - 1
 * ---------------
 * -> create a target array
 * -> shift each element right until you reach the index to be filled
 * -> update the index
 * 
 * 
 *  TC 
 * ----
 * Worst case -> O(n2);
 * Best case -> O(n);
 * Average case -> O(n2);
 */

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int i = 0 , n = nums.length;
        int[] target = new int[n];

        while(i < n) {
            for(int j = n-1; j > index[i]; j--){
                target[j] = target[j-1];
            }
            target[index[i]] = nums[i];
        }

        return target;
    }
}


/**
 *   Solution - 2
 * -----------------
 * -> Use ArrayList's add method  , it automatically updates the array accordingly
 *  
 *   ArrayList. add(int index, E elemen)
 * 
 *  TC
 * ----
 * -> Inserting at an index in arraylist -> O(N);
 * so, TC -> O(n2) 
 * 
 */

 class Solution {
    public int[] createTargetArray(int[] nums, int[] index){
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;
        int[] target = new int[n];

        for(int i = 0; i < n; i++){
            list.add(index[i], nums[i]);
        }

        for(int i = 0; i < n; i++) {
            target[i] = list.get(i);
        }

        return target;
    }
 }