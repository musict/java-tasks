package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
Изучи класс Circle. Напиши максимальное количество конструкторов с разными аргументами.

Подсказка:
не забудь про конструктор по умолчанию.
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    public Circle(double x) {
        this.x = x;
    }

    public Circle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle() {
    }

    public static void main(String[] args) {

    }
}