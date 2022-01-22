package com.dongdong.spring.test.sort;

import ch.qos.logback.core.db.dialect.SybaseSqlAnywhereDialect;

/**
 * 打印纸的所有折痕
 */
public class PaperFolding {

    private  static void   printAllFolds(int N){
        processFolds(1,N,true);
    }

    private static void processFolds(int i, int N, boolean down) {
        if(i>N){
            return;
        }
        processFolds(i+1,N,down);
        System.out.println(down ? "down":"up");
        processFolds(i+1,N,down);
    }
}
