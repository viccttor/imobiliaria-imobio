package br.com.imobio.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
@Entity
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "building",targetEntity = Apartment.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Apartment> apartmentList = new ArrayList<>();
}
