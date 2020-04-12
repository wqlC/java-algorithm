import java.util.HashMap;
import java.util.Map;

/**
 * @author tailor
 * @create 2020/4/12 - 22:40
 * @mail wql2014302721@gmail.com
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 暴力解法
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSum2(int[] nums, int target) {
        // 使用hash表
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return new int[]{i, map.get(nums[i])};
            }else {
                map.put(target-nums[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 4, 3, 0};
        int target = 0;
        int[] res = new Solution().twoSum2(nums, target);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}