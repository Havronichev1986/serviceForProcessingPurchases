package org.example.entitties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserEntity {
    @Id
    private Long id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private char[] password;
    @Column(name = "email")
    private String email;
    @Column(name = "phoneNumber")
    private int phoneNumber;
}
