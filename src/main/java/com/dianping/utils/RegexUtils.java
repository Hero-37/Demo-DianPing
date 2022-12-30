package com.dianping.utils;

import cn.hutool.core.util.StrUtil;

public class RegexUtils {
    /**
     * 校验手机号是否有效
     * @param phone
     * @return true: 符合，false：不符合
     */
    public static boolean isPhoneInvalid(String phone) {
        return mismatch(phone, RegexPatterns.PHONE_REGEX);
    }

    // 校验正则表达式
    private static boolean mismatch(String str, String regex) {
        if (StrUtil.isBlank(str)) {
            return true;
        }
        return !str.matches(regex);
    }
}
