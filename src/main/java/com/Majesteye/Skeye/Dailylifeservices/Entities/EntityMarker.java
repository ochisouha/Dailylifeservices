package com.Majesteye.Skeye.Dailylifeservices.Entities;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@Table(name="markers")
public class EntityMarker  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="place_name", length=128, nullable = false )
    private String name;

    @Column(name="location", length=128 , nullable = false )
    private String location;

    @Column(name="category" , length = 128, nullable = false )
    private String category;

    @Column(name="longitude" , length = 128, nullable = false )
    private float longitude;

    @Column(name="latitude" , length = 128, nullable = false )
    private float latitude;

    @Column(name="description" , length = 128 )
    private String description;

    @Column(name="contact", length=128 )
    private String contact;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private EntityUser user;
}
