package Advance_dsa_java.dp;

public class lcs_tabulation {

    public static int LCS_Tabulation(String str1, String str2, int n, int m) {

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {

        String str1 = "abcde";
        String str2 = "acde";
        int n = str1.length();
        int m = str2.length();
        System.out.println(LCS_Tabulation(str1, str2, n, m));
    }
}