import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tailor
 * @create 2020/4/14 - 8:11
 * @mail wql2014302721@gmail.com
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length<4){
            return result;
        }
        Arrays.sort(nums);//O(nlog(n))
        int length = nums.length;
        // 定义 i, j, l, r
        for (int i = 0; i < length-3; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            int min = nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
            if(min > target){
                break;
            }
            int max = nums[i]+nums[length-1]+nums[length-2]+nums[length-3];
            if(max < target){
                continue;
            }
            for (int j = i+1; j < length-2; j++) {
                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int l = j+1;
                int r = length-1;
                min = nums[i] + nums[j] + nums[l] + nums[l+1];
                if(min>target){
                    break;
                }
                max = nums[i] + nums[j] + nums[r] + nums[r-1];
                if(max<target){
                    continue;
                }
                while (l < r){
                    int cur = nums[i] + nums[j] + nums[l] + nums[r];
                    if(cur == target){
                        result.add( Arrays.asList(nums[i], nums[j], nums[l], nums[r]) );
                        l++;
                        r--;
                        while ( l<r && nums[l] == nums[l-1] ) l++;
                        while ( l<r && nums[r] == nums[r+1] ) r--;
                        r--;
                    }else if( cur < target ){
                        l++;
                        while ( l<r && nums[l] == nums[l-1] ) l++;
                    }else{
                        while (l<r && nums[r] == nums[r+1]) r--;
                    }

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(new Solution().fourSum(nums, target));
    }
}
