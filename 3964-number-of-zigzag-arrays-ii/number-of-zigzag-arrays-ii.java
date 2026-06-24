class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int SIZE = m * 2;

        long[][] trans = new long[SIZE][SIZE];

        for (int v = 0; v < m; v++) {
            for (int t = 0; t < 2; t++) {
                int from = v * 2 + t;
                if (t == 0) {
                    for (int u = 0; u < v; u++)
                        trans[u * 2 + 1][from] = 1;
                } else {
                    for (int u = v + 1; u < m; u++)
                        trans[u * 2 + 0][from] = 1;
                }
            }
        }

        long[] init = new long[SIZE];
        for (int p = 0; p < m; p++) {
            for (int c = 0; c < m; c++) {
                if (c > p) init[c * 2 + 0] = (init[c * 2 + 0] + 1) % MOD;
                else if (c < p) init[c * 2 + 1] = (init[c * 2 + 1] + 1) % MOD;
            }
        }

        long[] result = matVecMul(matPow(trans, n - 2), init, SIZE);

        long ans = 0;
        for (long x : result) ans = (ans + x) % MOD;
        return (int) ans;
    }

    private long[][] matMul(long[][] A, long[][] B, int sz) {
        long[][] C = new long[sz][sz];
        for (int i = 0; i < sz; i++)
            for (int k = 0; k < sz; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < sz; j++)
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
            }
        return C;
    }

    private long[][] matPow(long[][] M, long p) {
        int sz = M.length;
        long[][] result = new long[sz][sz];
        for (int i = 0; i < sz; i++) result[i][i] = 1;
        while (p > 0) {
            if ((p & 1) == 1) result = matMul(result, M, sz);
            M = matMul(M, M, sz);
            p >>= 1;
        }
        return result;
    }

    private long[] matVecMul(long[][] M, long[] v, int sz) {
        long[] res = new long[sz];
        for (int i = 0; i < sz; i++)
            for (int j = 0; j < sz; j++)
                res[i] = (res[i] + M[i][j] * v[j]) % MOD;
        return res;
    }
}