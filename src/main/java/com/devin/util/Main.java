package com.devin.util;

import cn.hutool.crypto.SecureUtil;
import org.junit.Test;

/**
 * @author: simpl
 * @date: 2020/2/21
 * @time: 21:26
 * @description: 
 */
public class Main {

    @Test
    public static void main(String[] args) {
        System.out.println(SecureUtil.md5("devin"));
    }
}
