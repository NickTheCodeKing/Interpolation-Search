import java.util.Random;
import java.util.Arrays;

public class Tester{

    public static void main(String[] args){

        // Sequential Arrays
        int[] array1 = generateSortedArray(100);
        int[] array2 = generateSortedArray(500);
        int[] array3 = generateSortedArray(1000);
        int[] array4 = generateSortedArray(10000);
        int[] array5 = generateSortedArray(100000);

        // Non-Sequential Uniformly Distributed Arrays
        int[] arr1 = generateSortedUniformArray(100, 200);
        int[] arr2 = generateSortedUniformArray(500, 1000);
        int[] arr3 = generateSortedUniformArray(1000, 5000);
        int[] arr4 = generateSortedUniformArray(2000, 3000);
        int[] arr5 = generateSortedUniformArray(10000, 100000);

        // Random Sorted Arrays
        int[] randomArray1 = generateSortedRandomArray(100, 100);
        int[] randomArray2 = generateSortedRandomArray(200, 200);
        int[] randomArray3 = generateSortedRandomArray(500, 1000);
        int[] randomArray4 = generateSortedRandomArray(10000, 100000);
        int[] randomArray5 = generateSortedRandomArray(100000, 500);

        // Unevenly Distributed Arrays
        int[] unevenArray1 = generateUnevenlyDistributedArray(100, 200);
        int[] unevenArray2 = generateUnevenlyDistributedArray(500, 1000);
        int[] unevenArray3 = generateUnevenlyDistributedArray(1000, 5000);
        int[] unevenArray4 = generateUnevenlyDistributedArray(2000, 3000);
        int[] unevenArray5 = generateUnevenlyDistributedArray(10000, 100000);

        // Exponentially Distributed Arrays
        int[] exponentialArray1 = generateExponentialArray(10, 2);
        int[] exponentialArray2 = generateExponentialArray(10, 3);
        int[] exponentialArray3 = generateExponentialArray(15, 3);
        int[] exponentialArray4 = generateExponentialArray(20, 4);
        
        // Sequential Arrays Tests
        

        System.out.println("********* Binary Vs Interpolation: n = 100 *********");
        compareSearchAlgorithms(array1, 1000);

        System.out.println("********* Binary Vs Interpolation: n = 500 *********");
        compareSearchAlgorithms(array2, 1000);

        System.out.println("********* Binary Vs Interpolation: n = 1,000 *********");
        compareSearchAlgorithms(array3, 1000);

        System.out.println("********* Binary Vs Interpolation: n = 10,000 *********");
        compareSearchAlgorithms(array4, 1000);

        System.out.println("********* Binary Vs Interpolation: n = 100,000 *********");
        compareSearchAlgorithms(array5, 1000);


        // Non-Sequential Uniformly Distributed Arrays Tests


        System.out.println("********* Binary Vs Interpolation: n = 100; Range = 200 *********");
        compareSearchAlgorithms(arr1, 1000);

        System.out.println("********* Binary Vs Interpolation: n = 500; Range = 1,000 *********");
        compareSearchAlgorithms(arr2, 1000);

        System.out.println("********* Binary Vs Interpolation: n = 1,000; Range = 5,000 *********");
        compareSearchAlgorithms(arr3, 1000);

        System.out.println("********* Binary Vs Interpolation: n = 2,000; Range = 3,000 *********");
        compareSearchAlgorithms(arr4, 1000);

        System.out.println("********* Binary Vs Interpolation: n = 10,000; Range = 100,000 *********");
        compareSearchAlgorithms(arr5, 1000);


        // Random Sorted Arrays Tests


        System.out.println("********* Binary Vs Interpolation: n = 100; Range = 100 *********");
        compareSearchAlgorithms(randomArray1, 1000);

        System.out.println("********* Binary Vs Interpolation: n = 200; Range = 200 *********");
        compareSearchAlgorithms(randomArray2, 1000);

        System.out.println("********* Binary Vs Interpolation: n = 1,000; Range = 5,000 *********");
        compareSearchAlgorithms(randomArray3, 1000);

        System.out.println("********* Binary Vs Interpolation: n = 2,000; Range = 3,000 *********");
        compareSearchAlgorithms(randomArray4, 1000);

        System.out.println("********* Binary Vs Interpolation: n = 100,000; Range = 500 *********");
        compareSearchAlgorithms(randomArray5, 1000);


        // Unevenly Distributed Arrays Tests


        System.out.println("********* Binary Vs Interpolation: n = 100; Range = 200 *********");
        compareSearchAlgorithms(unevenArray1, 1000);

        System.out.println("********* Binary Vs Interpolation: n = 500; Range = 1,000 *********");
        compareSearchAlgorithms(unevenArray2, 1000);

        System.out.println("********* Binary Vs Interpolation: n = 1,000; Range = 5,000 *********");
        compareSearchAlgorithms(unevenArray3, 1000);

        System.out.println("********* Binary Vs Interpolation: n = 2,000; Range 3,000 *********");
        compareSearchAlgorithms(unevenArray4, 1000);

        System.out.println("********* Binary Vs Interpolation: n = 10,000; Range = 100,000 *********");
        compareSearchAlgorithms(unevenArray5, 1000);

        // Exponentially Distributed Arrays Tests


        System.out.println("********* Binary Vs Interpolation: n = 10,  Base = 2*********");
        compareSearchAlgorithms(exponentialArray1, 1000);

        System.out.println("********* Binary Vs Interpolation: n = 10,  Base = 3*********");
        compareSearchAlgorithms(exponentialArray2, 1000);

        System.out.println("********* Binary Vs Interpolation: n = 15,  Base = 3*********");
        compareSearchAlgorithms(exponentialArray3, 1000);

        System.out.println("********* Binary Vs Interpolation: n = 20,  Base = 4*********");
        compareSearchAlgorithms(exponentialArray4, 1000);

        


    }

    private static int interpolationSearch(int[] array, int value){
        
        int high = array.length - 1; //upper-bound
        int low = 0;

        while(value >= array[low] && value <= array[high] && low <= high){

            int probe = low +                           // Starting point of the probe
                        (int)((double)(high - low) *    // Distance between the upper and lower bounds
                        (value - array[low]) /          // How far the value is from the lower bound
                        (array[high] - array[low]));    // Distance between the upper and lower bound elements

            if(array[probe] == value){
                return probe;
            }else if(array[probe] < value){
                low = probe + 1;
            }else {
                high = probe - 1;
            }
        }

        return -1;
    }

    private static int binarySearch(int[] array, int target){

        int low = 0;
        int high = array.length - 1;

        while(low <= high){
            
            int middle = low + (high - low) / 2;
            int value = array[middle];

            if(value < target){
                low = middle + 1;
            }else if(value > target){
                high = middle - 1;
            }else{
                return middle; // target found
            }
        }
        return -1; // target not found
    }

    private static int[] generateSortedArray(int length){
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i; // fill the array with ascending numbers
        }
        return arr;
    }

    private static int[] generateSortedUniformArray(int n, int range) {
        int[] array = new int[n];
        Random random = new Random();
    
        // Generate the first element randomly
        array[0] = random.nextInt(range);
    
        // Generate the remaining elements uniformly distributed
        for (int i = 1; i < n; i++) {
            array[i] = array[i - 1] + 1 + random.nextInt(range / n);
        }
    
        return array;
    }

    private static int[] generateSortedRandomArray(int n, int range) {
        // create a new random number generator
        Random rand = new Random();
        
        // create a new array of size n
        int[] arr = new int[n];
        
        // populate the array with random integers
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(range);
        }
        
        // sort the array
        Arrays.sort(arr);
        
        return arr;
    }

    private static int[] generateUnevenlyDistributedArray(int n, int range) {
        int[] array = new int[n];
        Random random = new Random();
        int start = 0;
        int end = range;
        int mid = range / 2;
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                array[i] = random.nextInt(mid - start) + start;
            } else {
                array[i] = random.nextInt(end - mid) + mid;
            }
        }
        Arrays.sort(array);
        return array;
    }

    private static int[] generateExponentialArray(int n, int base) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) Math.pow(base, i);
        }
        return arr;
    }

    private static void compareSearchAlgorithms(int[] array, int numTests) {
        Random rand = new Random();
        long binaryTotalTime = 0;
        long interpolationTotalTime = 0;
    
        for (int i = 0; i < numTests; i++) {
            int value = rand.nextInt(array.length + 1); // generates a random value between 0 and the array length + 1 (exclusive)
    
            // Binary search
            long startTime = System.nanoTime();
            int index = binarySearch(array, value);
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            binaryTotalTime += elapsedTime;
    
            // Interpolation search
            startTime = System.nanoTime();
            index = interpolationSearch(array, value);
            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            interpolationTotalTime += elapsedTime;
        }
    
        double binaryAvgTime = (double) binaryTotalTime / numTests;
        double interpolationAvgTime = (double) interpolationTotalTime / numTests;
    
        System.out.println("Binary search average time: " + binaryAvgTime + " ns");
        System.out.println("Interpolation search average time: " + interpolationAvgTime + " ns");
        System.out.println("Difference between average time: " + Math.abs((interpolationAvgTime - binaryAvgTime)) + " ns");

        System.out.println("\n");
    }
}