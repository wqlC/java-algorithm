import java.util.*;

/**
 * @author tailor
 * @create 2020/4/12 - 23:11
 * @mail wql2014302721@gmail.com
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);// 以此去重
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> value = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(value);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    // 双指针
    public List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length<2){
            return res;
        }

        Arrays.sort(nums);// 排序数据
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0) break; // 数组排过序的
            if(i>0 && nums[i] == nums[i-1]) continue;// 去重
            int l = i+1;
            int r = nums.length-1;
            while (l < r){
                int temp = nums[i] + nums[l] + nums[r];
                if(temp == 0){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l<r && nums[l] == nums[l+1]) l++; // 去重
                    while(l<r && nums[r] == nums[r-1]) r--;	// 去重
                    l++;
                    r--;
                }else if(temp<0){
                    l++;
                }else {
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new Solution().threeSum2(nums);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
