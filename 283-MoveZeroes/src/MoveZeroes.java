import java.awt.font.NumericShaper;

/**
 * @author tailor
 * @create 2020/4/10 - 16:08
 * @mail wql2014302721@gmail.com
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int noZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[noZero++] = nums[i];
            }
        }
        for (int i = noZero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
    public void moveZeroes2(int[] nums) {
        int noZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                if(i!=noZero){
                    swap(nums, noZero++, i);
                }else{
                    noZero++;
                }
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        new MoveZeroes().moveZeroes2(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
