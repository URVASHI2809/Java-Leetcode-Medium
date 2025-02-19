class GetHappyString {
    public String getHappyString(int n, int k) {
        int totalCount = (int) Math.pow(2, n - 1) * 3;
        if (k > totalCount) return "";

        StringBuilder result = new StringBuilder();
        char[] chars = {'a', 'b', 'c'};
        k--;
        for (int i = 0; i < n; i++) {
            int groupSize = (int) Math.pow(2, n - i - 1);
            for (char c : chars) {
                if (result.length() == 0 || result.charAt(result.length() - 1) != c) {
                    if (k < groupSize) {
                        result.append(c);
                        break;
                    }
                    k -= groupSize;
                }
            }
        }
        return result.toString();
    }
}
