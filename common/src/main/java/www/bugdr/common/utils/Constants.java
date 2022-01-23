package www.bugdr.common.utils;

/**
 * 抽取常量
 */
public interface Constants {
    interface User {
        String KEY_EMAIL_CODE_IP = "key_email_code_ip_";
        String KEY_EMAIL_CODE_ADDRESS = "key_email_code_address_";
        String KEY_EMAIL_CODE = "key_email_code_";
    }

    interface TimeSecond {
        int ONE = 1; // 1s
        int SIXTY = 60; // 1min
        int MIN = ONE * SIXTY; // 1min
        int FIVE_MIN = 5 * SIXTY; // 5min
        int HOUR = MIN * SIXTY; // 1hour
        int TWO_HOUR = 2 * HOUR; // 2hour
        int DAY = 24 * HOUR; // 1day
    }
}
