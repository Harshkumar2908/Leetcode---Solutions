class Solution {
    static int[][] arr;
    public int uniquePaths(int m, int n) {
        arr=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(arr[i],-1);
        return helper(m,n,0,0);
    }
    public int helper(int m,int n,int i,int j){
        if(i==m-1 || j==n-1) return 1;
        if(arr[i][j]!=-1) return arr[i][j];

        arr[i][j]=helper(m,n,i+1,j)+helper(m,n,i,j+1);
        return arr[i][j];
    }
}