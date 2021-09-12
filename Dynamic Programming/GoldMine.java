import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                arr[i][j] = scn.nextInt();
        
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        
        int ans = 0;
        for(int i=0; i<n; i++){
            int localAns = maxGold(i, 0, arr, dp);
            ans = Math.max(ans, localAns);
        }
        System.out.println(ans);
    }
    
    public static int maxGold(int r, int c, int[][] arr, int[][] dp){
        if(r < 0 || r >= arr.length){
            // negative base case
            return 0;
        }
        
        if(c == arr[0].length - 1){
            return arr[r][c];
        }
        
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        
        int up = maxGold(r - 1, c + 1, arr, dp);
        int right = maxGold(r, c + 1, arr, dp);
        int down = maxGold(r + 1, c + 1, arr, dp);
        
        int ans = arr[r][c] + Math.max(up, Math.max(right, down));
        dp[r][c] = ans;
        return ans;
    }

}
