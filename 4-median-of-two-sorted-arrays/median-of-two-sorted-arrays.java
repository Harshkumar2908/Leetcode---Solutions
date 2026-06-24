public class Solution {
    public static double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length) {
            return findMedianSortedArrays(b, a);
        }
        int sizeA = a.length;
        int sizeB = b.length;
        int low = 0;
        int high = a.length;

        while (low <= high) {
            int partitionA = (low + high) / 2;
            int partitionB = (sizeA + sizeB + 1) / 2 - partitionA;

            int maxLeftA = (partitionA == 0)? Integer.MIN_VALUE : a[partitionA - 1];
            int minRightA = (partitionA == sizeA)? Integer.MAX_VALUE : a[partitionA];

            int maxLeftB = (partitionB == 0)? Integer.MIN_VALUE : b[partitionB - 1];
            int minRightB = (partitionB == sizeB)? Integer.MAX_VALUE : b[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((sizeA + sizeB) % 2 == 0) {
                    int leftMax = Math.max(maxLeftA, maxLeftB);
                    int rightMin = Math.min(minRightA, minRightB);
                    return ((long)leftMax + rightMin) / 2.0;
                } else {
                    return (double) Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                high = partitionA - 1;
            } else {
                low = partitionA + 1;
            }
        }
        throw new IllegalArgumentException("input arrays not sorted");
    }
}