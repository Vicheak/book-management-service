package com.vicheak.borrow.borrowservice.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "borrowers")
public class Borrower {

    private String id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private String address;
    private LocalDateTime joinDate;

}
