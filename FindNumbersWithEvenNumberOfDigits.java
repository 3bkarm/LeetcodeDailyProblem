class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            int x = nums[i], c = 0;
            while (x > 0) {
                ++c;
                x /= 10;
            }
            if (c % 2 == 0) {
                ++ans;
            }
        }
        return ans;
    }
}
