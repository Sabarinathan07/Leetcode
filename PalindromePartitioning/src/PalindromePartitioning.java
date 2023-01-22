import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];

        // Initialize the dp array
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }

        // Fill in the dp array
        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        // Backtrack to find all possible partitions
        backtrack(result, new ArrayList<>(), dp, s, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> partition, boolean[][] dp, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                partition.add(s.substring(start, i + 1));
                backtrack(result, partition, dp, s, i + 1);
                partition.remove(partition.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        List<List<String>> result = pp.partition("abbba");
        for (List<String> partition : result) {
            System.out.println(partition);
        }
    }
}
