import com.sun.org.apache.bcel.internal.generic.RET;
import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * @author tailor
 * @create 2020/4/11 - 1:24
 * @mail wql2014302721@gmail.com
 */
public class LengthOfLongestSubstring {
    // 不含有重复字符的 最长子串 的长度。
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int l = 0;
        int r = -1;
        int len = 0;
        while (l < s.length()) {
//            int temp = freq[s.charAt(r + 1)];
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(++r)]++;
                len = Math.max(len, r - l + 1);
            } else {// 左边界右移到重复元素后
                freq[s.charAt(l++)]--;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "hhhhhh";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }
}
