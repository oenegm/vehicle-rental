package com.project.vehiclerental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "maker")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "image_url", nullable = false)
    private String imageURL;

    // TODO: not sure if mappedBy is correct
    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    private List<Vehicle> vehicles;
}