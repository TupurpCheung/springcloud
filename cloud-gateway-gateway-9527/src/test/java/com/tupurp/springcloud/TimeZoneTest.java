package com.tupurp.springcloud;

import java.time.ZonedDateTime;

/**
 * @description: 时区测试
 * @author: tupurp
 * @create: 2020-06-07 22:02
 */
public class TimeZoneTest {

    public static void main(String [] args){
        ZonedDateTime  zonedDateTime =  ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
}