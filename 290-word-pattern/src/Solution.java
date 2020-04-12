import java.util.HashMap;
import java.util.Map;

/**
 * @author tailor
 * @create 2020/4/12 - 21:21
 * @mail wql2014302721@gmail.com
 */
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strTemp = str.split(" ");
        char[] patternTemp = pattern.toCharArray();
        if(pattern.length() != strTemp.length){
            return false;
        }
        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < patternTemp.length; i++) {
            char ch = patternTemp[i];
            if (map.containsKey(ch)){
                if(!map.get(ch).equals(strTemp[i])){
                    return false;
                }
            }else if (map.containsValue(strTemp[i])){
                return false;
            }else{
                map.put(ch, strTemp[i]);
            }
        }
        return true;
    }
}