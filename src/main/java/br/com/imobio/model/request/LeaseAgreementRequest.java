package br.com.imobio.model.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class LeaseAgreementRequest {

    @NotBlank(message = "Required field")
    private TenantRequest tenant;

    @NotBlank(message = "Required field")
    private Integer durationInMonths;

    @NotBlank(message = "Required field")
    private Double price;

    @NotBlank(message = "Required field")
    private Double totalPrice;

}
