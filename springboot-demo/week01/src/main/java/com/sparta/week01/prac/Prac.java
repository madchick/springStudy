package com.sparta.week01.prac;

import java.util.ArrayList;
import java.util.List;

public class Prac {
    // public, static void 에 대해서는 곧 배웁니다! 우선은 넘어갈게요.
    public static void printInfo() {
        String title = "웹개발의 봄 Spring";
        String tutor = "남병관";
        int weeks = 5;
        float ratings = 5.0f;

        System.out.println("제목: " + title);
        System.out.println("튜터: " + tutor);
        System.out.println("주차: " + weeks);
        System.out.println("별점: " + ratings);
    }

    // 파라미터 X, 반환값 X
    public static void simplePrint() {
        System.out.println("파라미터도 없고, 반환값도 없어요!");
    }
    // 파라미터 O, 반환값 X
    public static void simpleSum(int num1, int num2) {
        System.out.println("num1 :" + num1 + ", num2: " + num2);
    }
    // 파라미터 X, 반환값 O
    public static int simpleReturn() {
        return 3;
    }
    // 파라미터 O, 반환값 O
    public static int sum(int num1, int num2) {
        return num1 + num2;
    }

    public static int countFruit(String given) {
        List<String> fruits = new ArrayList<>();
        fruits.add("감");
        fruits.add("배");
        fruits.add("감");
        fruits.add("딸기");
        fruits.add("수박");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("딸기");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("감");

        int count = 0;
        for (int i=0; i<fruits.size(); i++) {
            String fruit = fruits.get(i);
            if (given == fruit) {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        simplePrint();
        simpleSum(1,2);
        int ret = simpleReturn();
        System.out.println(ret);
        ret = sum(10,7);
        System.out.println(ret);

        List<String> fruits = new ArrayList<>();
        fruits.add("감");
        fruits.add("배");
        fruits.add("감");
        fruits.add("딸기");
        fruits.add("수박");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("딸기");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("감");
        System.out.println(fruits);

        System.out.println(fruits.get(0));
        System.out.println(fruits.get(1));
        System.out.println(fruits.get(2));
        System.out.println(fruits.get(3));
        System.out.println(fruits.get(4));
        System.out.println(fruits.get(5));
        System.out.println(fruits.get(6));
        System.out.println(fruits.get(7));
        System.out.println(fruits.get(8));
        System.out.println(fruits.get(9));
        System.out.println(fruits.get(10));
        System.out.println(fruits.get(11));
        System.out.println(fruits.get(12));

        for (int i=0; i<13; i++) {
            String fruit = fruits.get(i);
            System.out.println(fruit);
        }
        // 매번 13개, 14개, 12개.. 개수 세어줘야 할까요?

        for (int i=0; i<fruits.size(); i++) {
            String fruit = fruits.get(i);
            System.out.println(fruit);
        }

        List<String> celebs = new ArrayList<>();
        celebs.add("아이유");
        celebs.add("린다G");
        celebs.add("은비");
        celebs.add("금비");
        celebs.add("비");
        celebs.add("차은우");
        celebs.add("남주혁");
        celebs.add("수지");
        celebs.add("정우성");
        celebs.add("제니");
        celebs.add("정국");

        for (int i=0; i<celebs.size(); i++) {
            String celeb = celebs.get(i);
            System.out.println(celeb);
        }

        int age = 20;
        if (age > 19) {
            System.out.println("성인입니다.");
        } else {
            System.out.println("미성년자입니다.");
        }

        int count = 0;
        for (int i=0; i<fruits.size(); i++) {
            String fruit = fruits.get(i);
            if (fruit == "감") {
                count += 1;
            }
        }
        System.out.println(count);



        Course course = new Course();
        System.out.println(course.title);
        System.out.println(course.tutor);
        System.out.println(course.days);

        Course course2 = new Course("웹개발의 봄 스프링", "남병관", 35);
        System.out.println(course2.title);
        System.out.println(course2.tutor);
        System.out.println(course2.days);



        Tutor tutor = new Tutor();

        tutor.setName("웹개발의 봄 스프링");
        tutor.setBio("남병관");

        System.out.println(tutor.getName());
        System.out.println(tutor.getBio());
    }
}
