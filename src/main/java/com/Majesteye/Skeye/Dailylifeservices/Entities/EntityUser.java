package com.Majesteye.Skeye.Dailylifeservices.Entities;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="users")
public class EntityUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="username", length=64, nullable=false, unique=true)
    private String username;

    @Column(name="email", length=128, nullable=false, unique=true)
    private String email;


    @Column(name="password")
    private String password;

    @Column(name="profile")
    private Integer profile;
}
