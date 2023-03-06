package br.com.imobio.model.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

@ApiModel(value = "ApartmentRequest")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class ApartmentRequest {

    @ApiModelProperty(value = "Apartment availability")
    @NotBlank(message = "Required field")
    private boolean isAvailable;

    @ApiModelProperty(value = "Apartment number")
    @NotBlank(message = "Required field")
    private String aptNumber;

//    @ApiModelProperty(value = "Apartment owner")
//    @NotBlank(message = "Required field")
//    private AptOwnerRequest aptOwnerRequest;

//    @ApiModelProperty(value = "Apartment buildingResponse")
//    @NotBlank(message = "Required field")
//    private BuildingRequest buildingRequest;

}
