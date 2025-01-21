class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int a = 0;
        int i=0;
        while(i<arr.length){
             if(arr[i]>arr[i+1]){
                a = i;
                break;
            }
            i++;
        }

        return a;
    }
}