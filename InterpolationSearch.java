
public class InterpolationSearch{

    public static void main(String[] args){

        // Interpolation search =   improvement over binary search best used for "uniformly" distributed data
        //                          "guesses" where a value might be based on calculated probe results
        //                          if probe is incorrect, search area is narrowed, and a new probe is calculated

        //                          average case: O(log(log(n)))
        //                          worst case: O(n) [values increase exponentially]

    int[] array1 = {1, 2, 3, 4, 5};
    int index1 = interpolationSearch(array1, 3);
    System.out.println(index1); // Output: 2

    int[] array2 = {1, 2, 3, 4, 5};
    int index2 = interpolationSearch(array2, 6);
    System.out.println(index2); // Output: -1

    int[] array3 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    int index3 = interpolationSearch(array3, 60);
    System.out.println(index3); // Output: 5

    int[] array4 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    int index4 = interpolationSearch(array4, 110);
    System.out.println(index4); // Output: -1

    int[] array5 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
    int index5 = interpolationSearch(array5, 9);
    System.out.println(index5); // Output: 4

    int[] array6 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
    int index6 = interpolationSearch(array6, 8);
    System.out.println(index6); // Output: -1
}

    private static int interpolationSearch(int[] array, int value){
        
        int high = array.length - 1; //upper-bound
        int low = 0;

        while(value >= array[low] && value <= array[high] && low <= high){

            int probe = low +                       // Starting point of the probe
                        (high - low) *              // Distance between the upper and lower bounds
                        (value - array[low]) /      // How far the value is from the lower bound
                        (array[high] - array[low]); // Distance between the upper and lower bound elements

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
    
    
}