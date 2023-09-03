package ru.aston.druzhinin_ri.task1.model;

import lombok.*;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class User {
    private int age;
    private String name;
    private String sourName;
}
