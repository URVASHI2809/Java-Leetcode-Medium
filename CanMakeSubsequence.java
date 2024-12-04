public class CanMakeSubsequence {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;
        int n1 = str1.length();
        int n2 = str2.length();

        while (i < n1 && j < n2) {
            if ((str2.charAt(j) - str1.charAt(i) + 26) % 26 <= 1) {
                j++;
            }
            i++;
        }
        return j == n2;
    }

    public static void main(String[] args) {
        CanMakeSubsequence check = new CanMakeSubsequence();

        // Test case 1
        String str1 = "abc";
        String str2 = "ad";
        System.out.println("Test case 1: " + check.canMakeSubsequence(str1, str2)); // Expected: true

        // Test case 2
        str1 = "zc";
        str2 = "ad";
        System.out.println("Test case 2: " + check.canMakeSubsequence(str1, str2)); // Expected: true
    }
}
