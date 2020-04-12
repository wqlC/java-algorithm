import java.util.HashMap;

/**
 * @author tailor
 * @create 2020/4/12 - 21:45
 * @mail wql2014302721@gmail.com
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        // 使用字符映射
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length() && i<t.length(); i++) {
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);
            if(map.containsKey(sCh)){
                if(map.get(sCh) != tCh){
                    return false;
                }
            }else if(map.containsValue(tCh)){
                return false;
            }else{
                map.put(sCh, tCh);
            }
        }
        return true;
    }
}