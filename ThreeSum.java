import java.util.*;

public class ThreeSum {
    private List<List<Integer>> res;

    public List<List<Integer>> threeSum(int[] nums) {
        return new AbstractList<>() {
            public List<Integer> get(int index) {
                init();
                return res.get(index);
            }

            public int size() {
                init();
                return res.size();
            }

            private void init() {
                if (res != null) return;
                Arrays.sort(nums);
                int l, r, sum;
                Set<List<Integer>> tempRes = new HashSet<>();
                for (int i = 0; i < nums.length - 2; ++i) {
                    l = i + 1;
                    r = nums.length - 1;
                    while (l < r) {
                        sum = nums[i] + nums[l] + nums[r];
                        if (sum == 0) tempRes.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        if (sum < 0)
                            ++l;
                        else
                            --r;
                    }
                }
                res = new ArrayList<>(tempRes);
            }
        };
    }

    public static void main(String[] args) {
        ThreeSum sum = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = sum.threeSum(nums);
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
