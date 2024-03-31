package com.dongdong.spring.test.alBook.unit06BigData;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *认识布隆过滤器
 */
public class Class01_RecognizeBloomFilter {

    public static void main(String[] args) throws ParseException {
        System.out.println( DateTimeFormatter.ofPattern("M月d日HH:mm")
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2022-09-11 12:00:00")));
    }
}
