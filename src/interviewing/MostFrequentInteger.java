package interviewing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    * https://www.youtube.com/watch?v=yeCsuIk9vp0&ab_channel=interviewing.io
 */
public class MostFrequentInteger {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,5,5,6,6,7,9,8,1,1,2,1,1,5,5,5,5,5};

        int mostFrequent=MostFrequentInteger.findMostFrequentInteger(array);
        System.out.println(mostFrequent);

        MostFrequentInteger.findPairThatSums(array,10);
        int noPair = MostFrequentInteger.findIntegerWithNoPair(new int[]{2,2,1,3,3});
        System.out.println(noPair);

        int noPairXOR = MostFrequentInteger.findIntegerWithNoPairWithXOR(new int[]{2,2,8,3,3});
        System.out.println(noPairXOR);

    }


    public static int findMostFrequentInteger(int[] array){
        HashMap<Integer, Integer>  uniqueNumbers = findUniqueNumbers(array);
        Integer mostFrequent = null;

        for (Map.Entry<Integer,Integer> entry:uniqueNumbers.entrySet()) {
            if (mostFrequent == null){
                mostFrequent = entry.getKey();
                continue;
            }

            if (entry.getValue() > uniqueNumbers.get(mostFrequent)) {
                mostFrequent = entry.getKey();
            }
        }

        return mostFrequent;
    }

    private static HashMap<Integer, Integer> findUniqueNumbers(int[] array){
        HashMap<Integer, Integer>  uniqueNumbers = new HashMap<>();
        for (int i = 0; i < array.length; i++){
            Integer numberOfTimesSeen = uniqueNumbers.get(array[i]);
            if (numberOfTimesSeen == null){
                uniqueNumbers.put(array[i],1);
            } else {
                uniqueNumbers.replace(array[i],numberOfTimesSeen+1);
            }
        }

        return uniqueNumbers;
    }

    public static void findPairThatSums(int[] array, int sumTarget){
        Arrays.sort(array);

        int low = 0;
        int high = array.length -1;

        int indexFound = Arrays.binarySearch(array,sumTarget);

        if (indexFound >= 0 ){
            high = indexFound -1 ;
        }

        while (low < high){
            int tempSum = array[low] + array[high];
            if (tempSum == sumTarget){
                System.out.println(array[low] + " " + " "+  array[high]);
                high--;
                low = 0;
            }
            if (tempSum > sumTarget){
                high--;
                low = 0;
            }

            if (tempSum < sumTarget) {
                low++;
            }
        }
    }

    public static int findIntegerWithNoPair(int[] array) {
        if (array.length < 3){
            return Integer.MIN_VALUE;
        }
        Arrays.sort(array);

        for (int i = 0; i<array.length -1;i+=2){
            if (array[i] != array[i+1]){
                return array[i];
            }
        }

        return array[array.length -1];
    }

    public static int findIntegerWithNoPairWithXOR(int[] array) {
        if (array.length < 3){
            return Integer.MIN_VALUE;
        }

        int total = array[0];

        for (int i = 1; i<array.length;i++){
            total ^= array[i];
        }

        return total;
    }
}
