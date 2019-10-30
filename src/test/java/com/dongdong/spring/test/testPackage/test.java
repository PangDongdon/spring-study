package com.dongdong.spring.test.testPackage;

import org.junit.Test;
import org.mockito.internal.util.collections.Sets;

import java.util.Set;

/**
 * @Description:
 * @Date: 2019/10/15  9:46
 * @Author: dongdong
 */

public class test {
    @Test
    public void testSet(){
        Set  set= Sets.newSet();
        set.add(1);
        set.add(1);
        set.add(2);
        System.out.println(set+":"+set.size());
    }
}
