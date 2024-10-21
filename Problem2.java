// Time Complexity : O(nxk) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

package DP-4;

public class Problem2 {
    public int maxSumAfterPartitioningDP(int[] arr, int k) {
        int n = arr.length;
        int dp [] = new int[n];
        //add 0th arr element to dp
        dp[0] = arr[0];
        for(int i = 1; i < n; i++){ // O(nxk)
            int maxInPart = arr[i];
            // i -j + 1 >= 0 will check if at begining or end we can make k partition or no.
            //[1,15] we can only make 2 max 1 - 2 + 1 = 0 (j = 2), 1 -3 + 1 = -1 != 0 
            for(int j = 1; j <=k && i -j + 1>=0; j++){
                //int curRes = partition + rest sub problem
                maxInPart = Math.max(maxInPart, arr[i-j+1]);
                int curRes = maxInPart * j;
                if(i - j >= 0){
                    curRes += dp[i - j];
                }else{
                    curRes += 0;
                }
                dp[i] = Math.max(dp[i],curRes);
            }
        }
        return dp[n-1];
    }
}
