import java.util.HashMap;
import java.util.Map;

/**
 * @author tailor
 * @create 2020/4/12 - 20:42
 * @mail wql2014302721@gmail.com
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch, 1);
            }
        }
        for(char ch : t.toCharArray()){
            if(map.containsKey(ch)){
                if(map.get(ch)==1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch)-1);
                }
            }else{
                return false;
            }
        }
        return map.size() == 0;
    }
}
