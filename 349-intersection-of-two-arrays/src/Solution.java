import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author tailor
 * @create 2020/4/12 - 20:40
 * @mail wql2014302721@gmail.com
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums1){
            set.add(num);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int num:nums2){
            if(set.contains(num)){
                arrayList.add(num);
                set.remove(num);
            }
        }
        int[] res = new int[arrayList.size()];
        for(int i=0; i<arrayList.size(); i++){
            res[i] = arrayList.get(i);
        }
        return res;
    }
}
