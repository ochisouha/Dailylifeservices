package com.Majesteye.Skeye.Dailylifeservices.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@Table(name="feedbacks")
public class EntityFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rating", length = 164 , nullable = false)
    private String rating;

    @Column(name = "message", length = 128, nullable = false)
    private String message;
}