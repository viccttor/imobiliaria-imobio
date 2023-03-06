package br.com.imobio.model.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
@Entity
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isAvailable;

    private String aptNumber;

    @OneToOne(fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
    private AptOwner aptOwner;

    @ManyToOne(fetch = FetchType.LAZY)
    private Building building;

    @OneToOne
    private Tenant tenant;
    @OneToOne
    private LeaseAgreement leaseAgreement;

}
