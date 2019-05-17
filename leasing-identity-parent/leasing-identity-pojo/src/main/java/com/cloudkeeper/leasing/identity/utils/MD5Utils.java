/*    */
package com.cloudkeeper.leasing.identity.utils;
/*    */
/*    */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*    */

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class MD5Utils
        /*    */ {

    private static final String hexDigIts[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (null == charsetname || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        } catch (Exception e) {
        }
        return resultString;
    }

    public static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    public static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigIts[d1] + hexDigIts[d2];
    }

    /*    */
    public static String getPwd(String pwd)
    /*    */ {
        /*    */
        try
            /*    */ {
            /* 17 */
            MessageDigest digest = MessageDigest.getInstance("md5");
            /* 18 */
            byte[] result = digest.digest(pwd.getBytes());
            /* 19 */
            StringBuffer buffer = new StringBuffer();
            /*    */
            /* 21 */
            for (byte b : result)
                /*    */ {
                /* 23 */
                int number = b & 0xFF;
                /* 24 */
                String str = Integer.toHexString(number);
                /* 25 */
                if (str.length() == 1) {
                    /* 26 */
                    buffer.append("0");
                    /*    */
                }
                /* 28 */
                buffer.append(str);
                /*    */
            }
            /*    */
            /*    */
            /* 32 */
            return buffer.toString().toUpperCase();
            /*    */
        } catch (NoSuchAlgorithmException e) {
            /* 34 */
            e.printStackTrace();
        }
        /* 35 */
        return "";
        /*    */
    }
    /*    */
}

