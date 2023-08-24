package com.project.vehiclerental.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="name", unique = true)
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "image_url")
    private String imageURL;

    @OneToMany
    private List<Vehicle> vehicles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Brand brand = (Brand) o;
        return id != null && Objects.equals(id, brand.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}