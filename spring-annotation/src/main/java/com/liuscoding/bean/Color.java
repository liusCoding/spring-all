package com.liuscoding.bean;

/**
 * @className: Color
 * @description:
 * @author: liusCoding
 * @create: 2020-05-22 11:20
 */


public class Color {

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color [car=" + car + "]";
    }
}
