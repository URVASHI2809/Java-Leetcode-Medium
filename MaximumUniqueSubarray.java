class MaximumUniqueSubarray {
    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0;
        int[] record = new int[10001];
        int sum = 0;
        int n = nums.length;
        int left = 0;

        for (int right = 0; right < n; right++) {
            int cur = nums[right];
            sum += cur;
            record[cur]++;
            while (record[cur] > 1) {
                sum -= nums[left];
                record[nums[left]]--;
                left++;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
