import java.awt.*;
import java.util.Comparator;
import java.util.PrimitiveIterator;
import java.util.PriorityQueue;

/**
 * @author tailor
 * @create 2020/4/10 - 23:10
 * @mail wql2014302721@gmail.com
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {// 利用快排
        int len = nums.length;
        int targetIndex = len-k;
        int low = 0;
        int heigh = len-1;
        while(true){
            int i=partition(nums, low, heigh);
            if(i==targetIndex){
                return nums[i];
            }else if(i<targetIndex){
                low = i+1;
            }else{
                heigh = i-1;
            }
        }
    }

    private int partition(int[] nums, int low, int heigh) {
        int i = low;
        int pivot = nums[heigh];
        for (int j = low; j < heigh; j++) {
            if(nums[j] < pivot){
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, heigh);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 使用堆-优先队列-k-最小堆
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            if(heap.size()>k){
                heap.poll();
            }
        }
        return heap.poll();
    }
}
