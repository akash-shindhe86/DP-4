package DP-4;

public class Problem1 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int dp[] = new int [n + 1];
        for(int i = m - 1; i >=0; i--){
            int diagonal = 0;
            for(int j = n-1; j>=0; j--){
                int temp =dp[j];
                if(matrix[i][j] == '1'){
                    dp[j] = 1 + Math.min(dp[j], Math.min(diagonal, dp[j+1]));
                    max = Math.max(max, dp[j]);
                }else{
                    dp[j] = 0;
                }
                diagonal = temp;
            }
        }
        return max*max;  
    }
}