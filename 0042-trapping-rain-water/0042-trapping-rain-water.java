class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int n = height.length;
        int[] maxL = new int[n];
        int[] maxR = new int[n];
        int trappedWater = 0;

        // Compute maxL (maximum height to the left of each index)
        maxL[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxL[i] = Math.max(maxL[i - 1], height[i]);
        }

        // Compute maxR (maximum height to the right of each index)
        maxR[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxR[i] = Math.max(maxR[i + 1], height[i]);
        }

        // Compute trapped water at each index
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(maxL[i], maxR[i]) - height[i];
        }

        return trappedWater;
    }
}
