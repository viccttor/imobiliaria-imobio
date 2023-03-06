package br.com.imobio.model.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
@Entity
public class LeaseAgreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Tenant tenant;

    @OneToOne
    private AptOwner aptOwner;
    @OneToOne
    private Apartment apartment;

    private Integer durationInMonths;
    private Double price;
    private Double totalPrice;
}
