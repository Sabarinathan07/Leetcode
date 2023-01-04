import java.util.*;

class Solution {
    public int maxHeight(int[][] A) {

        for (int[] innerArr : A) {
            Arrays.sort(innerArr);

        }
        // for(int i=0;i<A.length;i++){
        // Arrays.sort(A[i],Collections.reverseOrder());
        // }

        Arrays.sort(A, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            }
            if (o1[1] != o2[1]) {
                return o2[1] - o1[1];
            }

            return o2[2] - o1[2];
        });
        int n = A.length, res = 0, dp[] = new int[n];
        for (int j = 0; j < n; ++j) {
            dp[j] = A[j][2];
            for (int i = 0; i < j; ++i) {
                if (A[i][0] >= A[j][0] && A[i][1] >= A[j][1] && A[i][2] >= A[j][2]) {
                    dp[j] = Math.max(dp[j], dp[i] + A[j][2]);
                }
            }
            res = Math.max(res, dp[j]);
        }
        return res;

    }
}