package br.com.imobio.model.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class LeaseAgreementResponse {

    private Long id;
    private TenantResponse tenantResponse;
    private AptOwnerResponse aptOwnerResponse;
    private RentApartmentResponse rentApartmentResponse;
    private Integer durationInMonths;
    private Double price;
    private Double totalPrice;
}
