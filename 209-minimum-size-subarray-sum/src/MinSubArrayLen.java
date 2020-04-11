/**
 * @author tailor
 * @create 2020/4/11 - 1:04
 * @mail wql2014302721@gmail.com
 */
public class MinSubArrayLen {
    // 暴力解法-遍历所有的连续子数组--- 超时
    public int minSubArrayLen(int s, int[] nums) {
        //该数组中满足其和 ≥ s 的长度最小的连续子数组
        int min = nums.length+1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if(sum(nums, i, j)>=s && (j-i+1)<min)
                    min = j-i+1;
            }
        }
        if(min == nums.length+1){
            return 0;
        }else
            return min;
    }

    private int sum(int[] nums, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum+=nums[k];
        }
        return sum;
    }

    // 使用滑动窗口
    public int minSubArrayLen2(int s, int[] nums) {
        //该数组中满足其和 ≥ s 的长度最小的连续子数组
        int sum = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            while (sum>=s){
                minLen = Math.min(minLen, i-left+1);
                sum-=nums[left];
                left++;
            }
        }
        if(minLen == Integer.MAX_VALUE){
            return 0;
        }else
            return minLen;
    }
    // 使用滑动窗口
    public int minSubArrayLen3(int s, int[] nums) {
        //该数组中满足其和 ≥ s 的长度最小的连续子数组
        int l = 0;
        int r = -1;
        int minLen = nums.length+1;
        int sum  = 0;
        while (l < nums.length){
            if(r+1<nums.length && sum<s)
                sum+=nums[++r];
            else
                sum-=nums[l++];
            if(sum>=s){
                minLen = minLen>(r-l+1)?(r-l+1):minLen;
            }
        }
        if (minLen == nums.length+1){
            return 0;
        }
        return minLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        int s = 7;
        System.out.println(new MinSubArrayLen().minSubArrayLen3(s, nums));
    }
}
