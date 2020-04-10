import java.util.Arrays;

/**
 * @author tailor
 * @create 2020/4/10 - 17:23
 * @mail wql2014302721@gmail.com
 */
public class SortColors {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
    public void sortColors2(int[] nums) {// 使用计数排序
        int[] counts = new int[3];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    public void sortColors3(int[] nums) {// 使用3路快排

        int redIndex = -1;
        int blueIndex = nums.length;
        for (int i = 0; i < blueIndex; ) {
            if(nums[i] == 1){
                i++;
            }else if(nums[i] == 0){
                redIndex++;
                swap(nums, redIndex, i);
                i++;
            }else if(nums[i] == 2){
                blueIndex--;
                swap(nums, blueIndex, i);
//                i++;// 重要
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0};
        new SortColors().sortColors3(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
