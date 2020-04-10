import java.util.concurrent.ForkJoinPool;

/**
 * @author tailor
 * @create 2020/4/10 - 23:48
 * @mail wql2014302721@gmail.com
 */
public class TwoSumII {
    // 穷举
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if(numbers[i]+numbers[j] == target){
                    return new int[]{i+1, j+1};
                }
            }
        }
        return new int[]{};
    }
    // 使用二分搜索法
    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int j = binarySearch(numbers, i+1, numbers.length-1, target-numbers[i]);
            if(j!=-1){
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{};
    }

    private int binarySearch(int[] numbers, int l, int r, int target) {
        if(l<=r){
            int mid = l+(r-l)/2;
            if(numbers[mid] == target){
                return mid;
            }
            if(numbers[mid] < target){
                return binarySearch(numbers, mid+1, r, target);
            }else{
                return binarySearch(numbers, l, mid-1, target);
            }
        }else{
            return -1;
        }
    }

    // 使用双指针法（对撞指针）
    public int[] twoSum3(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;
        while(l<r){
            if((numbers[l]+numbers[r])<target){
                l++;
            }else if((numbers[l]+numbers[r])>target){
                r--;
            }else{
                return new int[]{l+1, r+1};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] res = new TwoSumII().twoSum2(nums, target);
        System.out.println(res.length);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }

    //
}
