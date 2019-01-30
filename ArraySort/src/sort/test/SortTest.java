package sort.test;

import org.junit.Test;
import sort.method.HeapSort;

/**
 * @author wangsen@qgutech.com
 * @since 2019/1/14 15:21
 */
public class SortTest {

    @Test
    public void testHeapSort() throws Exception {
        HeapSort heapSort = new HeapSort();
        int[] sourceArr = new int[]{5, 2, 7, 3, 6, 1, 4};
        int[] sort = heapSort.sort(sourceArr);
        for (int i : sort) {
            System.out.print(i + ", ");
        }
    }
}
