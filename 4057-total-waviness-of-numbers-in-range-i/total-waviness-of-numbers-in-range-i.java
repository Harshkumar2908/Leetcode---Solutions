class Solution {
    private int waviness(int num){
        char[] arr = String.valueOf(num).toCharArray();
        int count = 0;
        for(int i=1;i<arr.length-1; i++){
            if((arr[i] > arr[i-1] && arr[i] > arr[i+1])||
            (arr[i] < arr[i-1] && arr[i] < arr[i+1])){
                count ++;
            }
        }  
        return count;
    }
    public int totalWaviness(int num1, int num2) {
        int res = 0;
        for(int num = num1;num<=num2;num++){
           res += waviness(num);
        }
       return res; 
    }
}