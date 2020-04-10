/**
 * @author tailor
 * @create 2020/4/11 - 0:27
 * @mail wql2014302721@gmail.com
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length-1;
        while (l<r){
            swap(s, l++, r--);
        }
    }

    private void swap(char[] s, int l, int r) {
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        new ReverseString().reverseString(s);
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]);
        }
    }
}
