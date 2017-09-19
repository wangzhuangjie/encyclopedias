package com.encyclopedias.util;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.RequestBody;
import okio.Buffer;

/**
 * Created by Frank on 2016/5/10.
 */
public class FETextUtils {
    /**
     * 检测是否为手机号码各式
     *
     * @param mobile 手机号码
     * @return 是否为正确号码，是为true，否为false
     */
    public static boolean isMobileFormat(String mobile) {
        Pattern p = Pattern.compile("1\\d{10}");
        return p.matcher(mobile).matches();
    }

    /**
     * 去除末尾0
     *
     * @param d
     * @return
     */
    public static String removeTrailingZeros(double d) {
        if (d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }

    public static boolean primitiveContains(int[] array, int item) {
        Arrays.sort(array);
        return (Arrays.binarySearch(array, item)) != -1;

    }

    public static String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

    public static String signRequestBody(String postBodyString, String secret) {
//        postBodyString.concat("&"
        StringBuilder sb = new StringBuilder();
        try {
            Pattern p = Pattern.compile("=([^&]+)");
            Matcher m = p.matcher(postBodyString);
            while (m.find()) {
                sb.append(URLDecoder.decode(m.group(1),"UTF-8"));
            }
        } catch (Exception ex) {
            // error handling

        }
        sb.append(secret);
        return MDUtil.getMD5(sb.toString());
    }
}
