package com.korayaks.springbootproject.entity;


import lombok.*;
import org.springframework.data.annotation.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;



@Document(indexName = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    @Field(name = "first name", type = FieldType.Text)
    private String firstName;
    @Field(name = "last name", type = FieldType.Text)
    private String lastName;
    @Field(name = "address", type = FieldType.Text)
    private String address;
    @Field(name = "age", type = FieldType.Text)
    private String age;
}
