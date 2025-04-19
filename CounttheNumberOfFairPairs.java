class Solution {
    public int lower_bound(int n, int val, int[] nums) {
        int lo = 0, hi = n - 1, ans = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if ( nums[mid] >= val ) {
                hi = mid - 1;
                ans = mid;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
    public int upper_bound(int n, int val, int[] nums) {
        int lo = 0, hi = n - 1, ans = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if ( nums[mid] > val ) {
                hi = mid - 1;
                ans = mid;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);

        long ans = 0;
        for (int i = 0; i < n; ++i) {
            int lo = lower - nums[i];
            int hi = upper - nums[i];
            int from = lower_bound(n, lo, nums);
            int to = upper_bound(n, hi, nums) - 1;
            if (from <= to) {
                ans += (to - from + 1);
                if (nums[i] >= lo && nums[i] <= hi) {
                    --ans;
                }
            }
        }

        return ans / 2;
    }
}
