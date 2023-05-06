package likou;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * 示例 1：
 *
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 */
public class No151 {
    public static void main(String[] args) {
        String s = "a b c d";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        int left=0,right=strings.length-1;
        while (left < right) {
            if(strings[left].equals("")){
                left++;
            }
            if(strings[right].equals("")){
                right--;
            }
            if(left<right&&!strings[left].equals("")&&!strings[right].equals("")){
                String temp = strings[left];
                strings[left] = strings[right];
                strings[right] = temp;
                left++;
                right--;
            }
        }
        StringBuffer buffer = new StringBuffer();
        for (String str:strings) {
            if(str.equals("")) continue;
            buffer.append(str).append(" ");
        }
        return buffer.toString().trim();
    }
}
