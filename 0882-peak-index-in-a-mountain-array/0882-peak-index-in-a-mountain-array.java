class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int a = 0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                a = i;
                break;
            }
        }

        return a;
    }
}