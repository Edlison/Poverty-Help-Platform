package com.edlison.marketing.utils;

import java.util.Random;

/**
 * RandomStr
 *
 * @Author Edlison
 * @Date 8/14/20 00:33
 */
public class RandomStr {

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
