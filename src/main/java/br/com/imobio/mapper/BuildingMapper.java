package br.com.imobio.mapper;

import br.com.imobio.model.entity.Building;
import br.com.imobio.model.request.BuildingRequest;
import br.com.imobio.model.response.BuildingResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BuildingMapper {

    private final ModelMapper mapper;
    private final ApartmentMapper apartmentMapper;

    public BuildingResponse toResponse(Building building) {
        BuildingResponse response = mapper.map(building, BuildingResponse.class);
        response.setApartmentResponseList(building.getApartmentList()
                .stream()
                .map(apartmentMapper::toResponse)
                .collect(Collectors.toList()));
        return response;
    }

    public Building toBuilding(BuildingResponse buildingResponse) {
        return mapper.map(buildingResponse, Building.class);
    }

    public Building toBuilding(BuildingRequest buildingRequest) {
        return mapper.map(buildingRequest, Building.class);
    }

}
