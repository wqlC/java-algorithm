import java.util.HashSet;
import java.util.Set;

/**
 * @author tailor
 * @create 2020/4/12 - 20:54
 * @mail wql2014302721@gmail.com
 */
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n!=1 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
    private int getNext(int n){
        int ret = 0;
        while(n!=0){
            int temp = n%10;
            n /= 10;
            ret += temp*temp;
        }
        return ret;
    }
    // 使用快慢指针
    public boolean isHappy2(int n) {
        int slow = n, fast = n;
        do{
            slow = getNext(slow);
            fast = getNext(fast);
            fast = getNext(fast);
        }while(slow != fast);

        return slow == 1;
    }
}
