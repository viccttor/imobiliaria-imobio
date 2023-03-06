package br.com.imobio.mapper;

import br.com.imobio.model.entity.*;
import br.com.imobio.model.request.ApartmentRequest;
import br.com.imobio.model.request.LeaseAgreementRequest;
import br.com.imobio.model.response.*;
import br.com.imobio.service.AptOwnerService;
import br.com.imobio.service.LeaseAgreementService;
import br.com.imobio.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Transactional
public class ApartmentMapper {

    private final ModelMapper mapper;
    private final AptOwnerService ownerService;
    private final TenantService tenantService;
    private final LeaseAgreementService leaseAgreementService;

    public ApartmentResponse toResponse(Apartment apartment) {
        BuildingResponseToApartment buildingResponse = mapper.map(apartment.getBuilding(), BuildingResponseToApartment.class);
        AptOwnerResponse aptOwnerResponse = mapper.map(apartment.getAptOwner(), AptOwnerResponse.class);
        ApartmentResponse  response = mapper.map(apartment, ApartmentResponse.class);
        response.setBuildingResponse(buildingResponse);
        response.setAptOwnerResponse(aptOwnerResponse);
        return response;
    }

    public Apartment toApartment(ApartmentResponse apartmentResponse) {
        return mapper.map(apartmentResponse, Apartment.class);
    }

    public Apartment toApartment(ApartmentRequest apartmentRequest) {
        return mapper.map(apartmentRequest, Apartment.class);
    }

    public Apartment toApartment(ApartmentRequest apartmentRequest, Building building) {
        Apartment apartment = mapper.map(apartmentRequest, Apartment.class);
        apartment.setBuilding(building);
        Optional<AptOwner> optAptOwner = ownerService.findById(1L);
        if (optAptOwner.isPresent()) {
            apartment.setAptOwner(optAptOwner.get());
        } else {
            AptOwner aptOwner = new AptOwner(1L, "BioPark");
            apartment.setAptOwner(ownerService.save(aptOwner));
        }
        return apartment;
    }

    public RentApartmentResponse toRentApartmentResponse(Apartment apartment, LeaseAgreementRequest leaseAgreementRequest) {
        RentApartmentResponse response = mapper.map(apartment, RentApartmentResponse.class);

        LeaseAgreement leaseAgreement = leaseAgreementService.create(leaseAgreementRequest);
        leaseAgreement.setApartment(apartment);
        leaseAgreement.setAptOwner(apartment.getAptOwner());
        Tenant tenant = tenantService.create(leaseAgreementRequest.getTenant());

        response.setTenantResponse(mapper.map(tenant, TenantResponse.class));
        response.setLeaseAgreementResponse(mapper.map(leaseAgreement, LeaseAgreementResponse.class));
        response.setAvailable(false);

        return  response;
    }
}
