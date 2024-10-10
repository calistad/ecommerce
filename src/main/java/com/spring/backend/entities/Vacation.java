package com.spring.backend.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="vacations")
@Data
public class Vacation {

    // Define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vacation_id")
    private Long id;

    @Column(name="vacation_title")
    private String vacationTitle;

    @Column(name="description")
    private String description;

    @Column(name="travel_fare_price")
    private BigDecimal travelPrice;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="create_date")
    @CreationTimestamp
    private Date createDate;

    @Column(name="last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacation")
    private Set<Excursion> excursions = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacation")
    private Set<CartItem> cartItem = new HashSet<>();

}
