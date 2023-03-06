package br.com.imobio.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class RentApartmentResponse extends ApartmentResponse {
    private TenantResponse tenantResponse;
    private LeaseAgreementResponse leaseAgreementResponse;

}