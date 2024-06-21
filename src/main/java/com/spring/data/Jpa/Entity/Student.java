package com.spring.data.Jpa.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "table_stdt",
        uniqueConstraints = @UniqueConstraint(
                name = "email_idunique",
                columnNames = "emailId"
        )
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(
            name = "emailId",
            nullable = false
    )
    private String emailId;

    @Embedded
    private Guardian guardian;
}
