package com.example.jpademo.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
@Table(name="user", indexes = { @Index(columnList="name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    // @Column(name="created", nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Transient
    private String testData;

    @PrePersist
    public void prePersist() {
        System.out.println(">>> prePersist");
    }
}
