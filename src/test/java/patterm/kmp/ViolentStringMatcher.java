package patterm.kmp;

public class ViolentStringMatcher {

    private static int indexOf(String source, String pattern) {
        int i = 0, j = 0;
        int sLen = source.length(), pLen = pattern.length();
        char[] src = source.toCharArray();
        char[] ptn = pattern.toCharArray();

        while (i < sLen && j < pLen) {

            if (src[i] == ptn[j]) {
                // 如果当前字符匹配成功,则将两者各自增1,继续比较后面的字符
                i++;
                j++;
            } else {
                // 如果当前字符匹配不成功,则i回溯到此次匹配最开始的位置+1处,也就是i = i - j + 1
                // (因为i,j是同步增长的), j = 0;
                i = i - j + 1;
                j = 0;
            }
        }
        // 匹配成功,则返回模式字符串在原字符串中首次出现的位置;否则返回-1
        if (j == pLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(indexOf("abcdefgdecfd", "cf"));
    }
}
