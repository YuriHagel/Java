package algorithm;

import java.util.Arrays;

/**
 * Блочная сортировка.
 */
class BucketSort {
  static void sort() {
    int[] array = new int[20];
    //Initializing array of random numbers
    for (int i = 0; i < array.length; i++) {
      array[i] = (int) Math.round(Math.random() * 100);
      //Display array
      System.out.print(array[i] + " ");
    }
    System.out.println();

    bucketSort(array);
    //Display array finish
    for (int i : array) System.out.print(i + " ");
  }

  private static void bucketSort(int[] arr) {
    int i, j;
    int[] bucket = new int[arr.length + 1000];
    Arrays.fill(bucket, 0);

    for (i = 0; i < arr.length; i++) {
      bucket[arr[i]]++;
    }

    int k = 0;
    for (i = 0; i < bucket.length; i++) {
      for (j = 0; j < bucket[i]; j++) {
        arr[k++] = i;
      }
    }
  }
}


