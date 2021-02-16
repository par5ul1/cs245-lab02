/**
 * @Author: Parsa Rahimi <par5ul1>
 * @Date:   2021-02-10T14:45:48-08:00
 * @Filename: Lab2.java
 * @Last modified by:   par5ul1
 * @Last modified time: 2021-02-15T21:52:40-08:00
 */

public class Lab2 {

  private int[] sort(int[] arr_og) { // Insertion Sort. Worst case: O(n^2+n) = O(n^2)

    // Create a duplicate of the original array so the final indices can be matched.
    int[] arr = new int[arr_og.length];
    for (int i = 0; i < arr_og.length; i++) {
      arr[i] = arr_og[i];
    }

    int tmp = arr[0]; // start the temp variable at the first item

    for (int i = 1; i < arr.length; i++) { // loop through the array starting at the second item and perform insertion sort
      int j = i-1;
      tmp = arr[i];
      while (j >= 0 && arr[j] > tmp) {
        arr[j+1] = arr[j];
        j--;
      }
      arr[j+1] = tmp;
    }

    return arr;
  }

  private int search(int[] arr, int target, int start, int end) { // Binary Search. Worst case: O(log_2(n))
    while (start <= end) { // As long as the high pointer and the low pointer haven't passed each other...
      int mid = (start+end)/2; // Set the midpoint
      if (target > arr[mid]) { // If the value is to the right...
        start = mid+1; // Ignore the left half
      } else if (target < arr[mid]) { // If the value is to the left...
        end = mid-1; // Ignore the right half
      } else { // This can only mean == because it wasn't < or >
        return mid; // The item was found
      }
    }
    return -1; // The item wasn't found so return -1
  }

  public int[] twoSum(int[] sum, int num) { // Two Sum. Worst Case: O(n^2)+O(n*log_2(n))+O(n) = O(n^2)
    int[] sumSorted = sort(sum); // Get a sorted version of the original array
    for (int i = 0; i < sum.length; i++) { // Loop through the list original list — O(n)...
      int match = search(sumSorted, num-sum[i], i+1, sumSorted.length-1); // ... and look for the complement of the current value (num-sum[i]) in the sorted list
      if (match > -1) { // If bubble sort yielded anything...
        for (int j = i+1; j < sum.length; j++) { // loop through the rest and look for the original index
          if (sumSorted[match] == sum[j]) {
            match = j; // replace the found index with the translated one
            break; // break out of the loop.
          }
        }
        int[] result = {i,match}; // format the output array
        return result; // return it
      }
    }
    int[] result = {-1}; // nothing was found so format the output array
    return result; // return it
  }

}
