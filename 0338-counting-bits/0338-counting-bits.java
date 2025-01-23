class Solution {
    public int[] countBits(int n) {

        String[] arra = new String[n+1];

        for(int i=0;i<arra.length;i++){
            arra[i]=Integer.toBinaryString(i);

        }

            for (int i = 0; i < arra.length; i++) {
            String binaryString = arra[i];
            

            int countOfOnes = countOnes(binaryString);
            
           
            arra[i] = String.valueOf(countOfOnes);
        }

     
        
    


   int[] intArray = Arrays.stream(arra)
                               .mapToInt(Integer::parseInt)
                               .toArray();

    return intArray;

        
    }

    public static int countOnes(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '1') {
                count++;
            }
        }
        return count;
    }
}
 