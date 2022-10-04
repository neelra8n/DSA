// link -> https://practice.geeksforgeeks.org/problems/max-distance-between-same-elements/1

/**
 *      Solution - 2
 * -----------------------
 * * use hashmap
 * * for new occurances, initalize value(as index)
 * * on next occurance update distance(max) by subtracting current index with index in value
 * 
 *  TC
 * ----
 * All cases -> O(N);
 * 
 *  SC
 * ----
 * O(N)
*/ 

class Solution
{
    int maxDistance(int arr[], int n)
    {   
	    Map<Integer, Integer> map = new HashMap<>();
	    int max = 0;
	    for(int i = 0; i < n; i++) {
	        if(map.containsKey(arr[i])) {
	            int prev = map.get(arr[i]);
	            max = Math.max(max, i-prev);
	        }
	        else{
	            map.put(arr[i], i);
	        }
	    }
	    return max;
    }
}
