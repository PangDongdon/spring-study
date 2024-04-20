package com.dongdong.spring.test2.sort.basic_class2;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueStack {

    private Queue<Integer> queue;
    private Queue<Integer> help;

    public TwoQueueStack() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    private void push(int num) {
        queue.add(num);
    }

    private int poll() {
        if (queue.isEmpty()) {
            throw new IllegalArgumentException("stack is empty");
        }
        while (queue.size() > 1) {
            help.add(queue.poll());
        }
        int res = queue.poll();
        swap();
        return res;
    }

    private int peek() {
        if (queue.isEmpty()) {
            throw new IllegalArgumentException("stack is empty");
        }
        while (queue.size() > 1) {
            help.add(queue.poll());
        }
        int res = queue.poll();
        help.add(res);
        swap();
        return res;
    }

    private void swap() {
        Queue<Integer> tmp = help;
        help = queue;
        queue = tmp;
    }

}
