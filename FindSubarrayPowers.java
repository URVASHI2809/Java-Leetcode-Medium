import java.util.Arrays;

public class FindSubarrayPowers {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = -1;
        }

        int i = 0, j = 0;
        while (j < n) {
            if (j > 0 && nums[j] - nums[j - 1] != 1) {
                i = j;
            }

            while (i < j && j - i + 1 > k) {
                i++;
            }

            if (j - i + 1 == k) {
                ans[j - k + 1] = nums[j];
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        FindSubarrayPowers result = new FindSubarrayPowers();

        int[] nums1 = {1, 2, 3, 4, 3, 2, 5};
        int k1 = 3;
        System.out.println(Arrays.toString(result.resultsArray(nums1, k1))); // Output: [3, 4, -1, -1, -1]

        int[] nums2 = {2, 2, 2, 2, 2};
        int k2 = 4;
        System.out.println(Arrays.toString(result.resultsArray(nums2, k2))); // Output: [-1, -1]

        int[] nums3 = {3, 2, 3, 2, 3, 2};
        int k3 = 2;
        System.out.println(Arrays.toString(result.resultsArray(nums3, k3))); // Output: [-1, 3, -1, 3, -1]
    }
}
