/**
 * @author tailor
 * @create 2020/4/11 - 0:14
 * @mail wql2014302721@gmail.com
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        String newS = s.toLowerCase();
        int l = 0;
        int r = newS.length()-1;
        while (l<r){
            if(!((newS.charAt(l)>='a'&&newS.charAt(l)<='z')||(newS.charAt(l)>='0'&&newS.charAt(l)<='9'))){
                l++;
                continue;
            }else if(!((newS.charAt(r)>='a'&&newS.charAt(r)<='z')||(newS.charAt(r)>='0'&&newS.charAt(r)<='9'))){
                r--;
                continue;
            }else{
                if(newS.charAt(l) == newS.charAt(r)){
                    l++;
                    r--;
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(new IsPalindrome().isPalindrome(s));
    }
}
