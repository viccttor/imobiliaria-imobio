package br.com.imobio.model.response;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class BuildingResponse {
    private Long id;
    private String name;
    private List<ApartmentResponse> apartmentResponseList = new ArrayList<>();
}
