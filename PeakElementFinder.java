public class PeakElementFinder {
        public int findPeakElement(int[] nums) {
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        public static void main(String[] args) {
            PeakElementFinder finder = new PeakElementFinder();

            int[] nums1 = {1, 2, 3, 1};
            System.out.println(finder.findPeakElement(nums1)); // Output: 2

            int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
            System.out.println(finder.findPeakElement(nums2)); // Output: 5 or 1
        }
}
