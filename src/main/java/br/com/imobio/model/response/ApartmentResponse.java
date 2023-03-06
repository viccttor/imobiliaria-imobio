package br.com.imobio.model.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class ApartmentResponse {

    private Long id;
    private boolean isAvailable;
    private String aptNumber;
    private AptOwnerResponse aptOwnerResponse;
    private BuildingResponseToApartment buildingResponse;

}
