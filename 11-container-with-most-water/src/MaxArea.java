/**
 * @author tailor
 * @create 2020/4/11 - 0:47
 * @mail wql2014302721@gmail.com
 */
public class MaxArea {
    public int maxArea(int[] height) {// 使用双指针法
        int l=0;
        int r = height.length-1;
        int max = 0;
        while (l<r){
            int tempWidth = r-l;
            if(height[l]<height[r]){
                max = Math.max(max, Math.min(height[l], height[r])*tempWidth);
                l++;
            }else{
                max = Math.max(max, Math.min(height[l], height[r])*tempWidth);
                r--;
            }
        }
        return max;
    }
}
