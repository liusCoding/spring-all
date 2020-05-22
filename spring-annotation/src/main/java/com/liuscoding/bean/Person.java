package com.liuscoding.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: Person
 * @description:
 * @author: liusCoding
 * @create: 2020-05-22 09:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;

    private Integer age;
}
