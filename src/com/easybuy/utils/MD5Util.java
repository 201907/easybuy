package com.easybuy.utils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MD5Util {
    /**
     * 字符串MD5加密
     * @param str
     * @return
     */
    public static String encodeStr(String str) throws NoSuchAlgorithmException{
        return  new BigInteger(1,MessageDigest.getInstance("MD5").digest(str.getBytes())).toString(16);
    }
}
