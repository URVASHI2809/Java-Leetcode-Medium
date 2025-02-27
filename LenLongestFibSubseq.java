class LenLongestFibSubseq {
  public int lenLongestFibSubseq(int[] arr) {
	int len = arr.length;
	int max = 0;
	int[][] dp = new int[len][len];
	for (int i = 2; i < len; i++) { 
		int low = 0, high = i-1;
		while (low < high) {
			int sum = arr[low] + arr[high];
			if (sum < arr[i]) {
				low++;
			} else if (sum > arr[i]) {
				high--;
			} else { 
				dp[high][i] = dp[low][high] + 1;
				max = Math.max(max, dp[high][i]);
				low++;
				high--;
			}
		}
	}
	return max > 0 ? max+2 : 0; 
  } 
}
