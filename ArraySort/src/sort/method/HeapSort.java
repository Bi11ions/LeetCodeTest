package sort.method;

import sort.ArraySort;

import java.util.Arrays;

/**
 * @author wangsen@qgutech.com
 * @since 2019/1/14 15:07
 */
public class HeapSort implements ArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int length = arr.length;
        buildMaxHeap(arr, length);

        for (int i = length - 1; i > 0 ; i--) {
            swap(arr, 0, i);
            length--;
            heapify(arr, 0, length);
        }

        return arr;
    }

    private void buildMaxHeap(int[] arr, int len) {
        for (int i = (int)Math.floor(len >> 1); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
