package demo;

import java.util.Comparator;
import java.util.PriorityQueue;

/*class Student implements Comparable<Student> {

    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}

// 比较器 - 以年龄进行比较
class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1,Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

public class Test {
    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        Student stu1 = new Student("a",20);
        Student stu2 = new Student("b",19);

        //System.out.println(stu1.compareTo(stu2));
        NameComparator nameComparator = new NameComparator();
        System.out.println(nameComparator.compare(stu1, stu2));

    }
}*/

// Top-k 问题
/*class Solution {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        int[] ret = new int[k];
        for (int i = 0;i < arr.length;i++) {
            priorityQueue.offer(arr[i]);
        }
        for (int i = 0;i < k;i++) {
            ret[i] = (int)priorityQueue.poll();
        }
        return ret;
    }
}*/

//
/*
class Imp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}
class Solution {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(new Imp());
        int[] ret = new int[k];
        if (k == 0) {
            return ret;
        }
        for (int i = 0;i < k;i++) {
            priorityQueue.offer(arr[i]);
        }
        for (int i = k;i < arr.length;i++) {
            Integer top = priorityQueue.peek();
            if (arr[i] < top) {
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        for (int i = 0;i < k;i++) {
            ret[i] = priorityQueue.poll();
        }
        return ret;
    }
}*/
