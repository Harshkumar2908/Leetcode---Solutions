import java.util.*;

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        long result = 0;
        int offset = n;
        int size = 3 * n + 2;
        int[] bit = new int[size + 2];
        
        int prefix = 0;
        update(bit, 0 + offset, size);
        
        for (int r = 0; r < n; r++) {
            if (nums[r] == target) prefix++;
            int keyR = 2 * prefix - (r + 1);
            int queryIdx = keyR - 1 + offset;
            if (queryIdx >= 0) {
                result += query(bit, Math.min(queryIdx, size));
            }
            update(bit, keyR + offset, size);
        }
        
        return result;
    }
    
    private void update(int[] bit, int i, int size) {
        i++;
        while (i <= size + 1) {
            bit[i]++;
            i += i & (-i);
        }
    }
    
    private int query(int[] bit, int i) {
        i++;
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= i & (-i);
        }
        return sum;
    }
}