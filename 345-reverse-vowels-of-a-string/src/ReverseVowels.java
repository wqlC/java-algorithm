import java.util.HashSet;
import java.util.Set;

/**
 * @author tailor
 * @create 2020/4/11 - 0:33
 * @mail wql2014302721@gmail.com
 */
public class ReverseVowels {
    public String reverseVowels(String s) {// 使用碰撞指针
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        char[] temp = s.toCharArray();
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            if(!vowels.contains(s.charAt(l))){
                l++;
                continue;
            }else if(!vowels.contains(s.charAt(r))){
                r--;
                continue;
            }else{
                swap(temp, l, r);
                l++;
                r--;
            }
        }
        s = new String(temp);
        return s;
    }

    private void swap(char[] temp, int l, int r) {
        char c = temp[l];
        temp[l] = temp[r];
        temp[r] = c;
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(new ReverseVowels().reverseVowels(s));
    }
}
