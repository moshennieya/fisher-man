package www.bugdr.common.utils;

public class TextUtils {

    /**
     * 判断字符串是否为空
     * @param text
     * @return
     */
    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }
}
