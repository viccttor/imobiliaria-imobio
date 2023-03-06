package br.com.imobio.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class RentApartmentRequest extends ApartmentRequest {

    @NotBlank(message = "Required field")
    private TenantRequest tenantRequest;

    @NotBlank(message = "Required field")
    private LeaseAgreementRequest leaseAgreementRequest;

}