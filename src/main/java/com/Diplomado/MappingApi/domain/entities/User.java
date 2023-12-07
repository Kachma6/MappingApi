package com.Diplomado.MappingApi.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @SequenceGenerator(name = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "user_sequence")
    private Integer userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String mail;
    private String password;
    @Column(name = "created_ts")
    private LocalDateTime createdTs;
    @Column(name = "update_ts")
    private LocalDateTime updateTs;

}
