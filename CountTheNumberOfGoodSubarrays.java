class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long ans = 0, c = 0;
        int l = 0, r = 0;
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        while (l < n) {
            while (r < n && c < k) {
                int f = 0;
                if ( mp.containsKey(nums[r]) ) {
                    f = mp.get(nums[r]);
                }
                c += f++;
                mp.put(nums[r++], f);
            }
            if (c < k) {
                break;
            }
            ans += (n - r + 1);
            int f = mp.get(nums[l]);
            c -= --f;
            mp.put(nums[l++], f);
        }
        return ans;
    }
}
