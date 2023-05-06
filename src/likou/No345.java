package likou;

/**
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * <p>
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "hello"
 * 输出："holle"
 */
public class No345 {
    public static void main(String[] args) {
        String s = " ";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        if(s.length()==0) return "";
        int left = 0, right = s.length() - 1;
        char[] chars = s.toLowerCase().toCharArray();
        String meta = "aeiou";
        while (left < right) {
            if (meta.indexOf(chars[left]) < 0) {
                left++;
            }
            if (meta.indexOf(chars[right]) < 0) {
                right--;
            }
            if (left<right&&meta.indexOf(chars[left]) > -1 && meta.indexOf(chars[right]) > -1) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
