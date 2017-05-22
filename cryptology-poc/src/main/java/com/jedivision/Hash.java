package com.jedivision;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    private static final Logger LOGGER = LoggerFactory.getLogger(Hash.class);

    public static String md5ViaPureJava(String value) throws NoSuchAlgorithmException {
        LOGGER.debug("Encoding {} with md5 hashing algorithm via pure Java", value);
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(value.getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    public static String md5ViaCommonsCodec(String value) {
        LOGGER.debug("Encoding {} with md5 hashing algorithm via commons codec", value);
        return DigestUtils.md5Hex(value);
    }
}