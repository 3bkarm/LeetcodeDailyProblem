class Solution {
    class BIT {
        private int n;
        private long[] tree;

        public void init(int _n) {
            n = _n;
            tree = new long[n];
        }

        public void add(int at, long value) {
            for (int i = at + 1; i <= n; i += i & -i)
                tree[i - 1] += value;
        }

        public long sum(int exc) {
            long ans = 0;
            for (int i = exc; i > 0; i -= i & -i)
                ans += tree[i - 1];
            return ans;
        }

        public long sum(int inc, int exc) {
            return sum(exc) - sum(inc);
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        long[] dp = new long[n];
        int[] p = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            p[ nums2[i] ] = i;
        }
        for (int it = 0; it < 2; ++it) {
            BIT tree = new BIT();
            tree.init(n);
            long[] newDp = new long[n];
            for (int i = 0; i < n; ++i) {
                newDp[ p[ nums1[i] ] ] = tree.sum( p[ nums1[i] ] );
                tree.add( p[ nums1[i] ], dp[ p[ nums1[i] ] ] );
            }
            dp = newDp;
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += dp[i];
        }
        return ans;
    }
}
