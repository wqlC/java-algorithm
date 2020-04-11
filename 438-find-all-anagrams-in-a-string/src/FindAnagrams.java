import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author tailor
 * @create 2020/4/11 - 11:34
 * @mail wql2014302721@gmail.com
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s==null||s.length() == 0) return list;

        int left = 0;
        int right = 0;
        int total = p.length();
        int[] needs = new int[26];
        int[] windows = new int[26];
        for (char c: p.toCharArray()) {
            needs[c-'a']++;
        }

        while (right<s.length()){
            char chr = s.charAt(right);
            if (needs[chr-'a']>0){// s当前元素在p中
                windows[chr-'a']++;
                if(windows[chr-'a']<=needs[chr-'a']){
                    total--;
                }
            }
            while (total == 0){
                if(right-left+1 == p.length()){
                    list.add(left);
                }
                char chl = s.charAt(left);
                if(needs[chl-'a']>0){
                    windows[chl-'a']--;
                    if(windows[chl-'a'] < needs[chl-'a']){
                        total++;
                    }
                }
                left++;
            }
            right++;
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List list = new FindAnagrams().findAnagrams(s, p);
        for(Iterator it = list.iterator(); it.hasNext();){
            System.out.print(it.next()+" ");
        }
    }
}
