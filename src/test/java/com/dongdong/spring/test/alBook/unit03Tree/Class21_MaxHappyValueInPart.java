package com.dongdong.spring.test.alBook.unit03Tree;

import java.util.List;

//派对的最大快乐值
public class Class21_MaxHappyValueInPart {

    public static class Employee {
        public int happy;//这名服务员带来的快乐值
        public List<Employee> subordinates;
    }

    public static class ReturnType {
        private int yesHeadMax;
        private int noHeadMax;

        public ReturnType(int yesHeadMax, int noHeadMax) {
            this.yesHeadMax = yesHeadMax;
            this.noHeadMax = noHeadMax;
        }
    }

    public static ReturnType process(Employee employee) {
        int yesX = employee.happy;
        int noX = 0;
        if (employee.subordinates.isEmpty()) {
            return new ReturnType(yesX, noX);
        } else {
            for (Employee e : employee.subordinates) {
                ReturnType data = process(e);
                yesX += data.noHeadMax;
                noX += Math.max(data.noHeadMax, data.yesHeadMax);
            }
        }
        return new ReturnType(yesX, noX);
    }

    public static int getMaxHappy(Employee employee) {
        ReturnType process = process(employee);
        return Math.max(process.noHeadMax, process.yesHeadMax);
    }

}
