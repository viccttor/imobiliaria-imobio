package br.com.imobio.service.impl;

import br.com.imobio.mapper.ApartmentMapper;
import br.com.imobio.model.entity.Apartment;
import br.com.imobio.model.entity.Building;
import br.com.imobio.model.entity.Tenant;
import br.com.imobio.model.repository.ApartmentRepository;
import br.com.imobio.model.request.ApartmentRequest;
import br.com.imobio.model.request.LeaseAgreementRequest;
import br.com.imobio.model.response.RentApartmentResponse;
import br.com.imobio.service.ApartmentService;
import br.com.imobio.service.BuildingService;
import br.com.imobio.service.exception.ApartmentNotFoundException;
import br.com.imobio.service.exception.BuildingNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository repository;
    private final ApartmentMapper mapper;
    private final BuildingService buildingService;


    @Override
    public List<Apartment> listAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Apartment> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Apartment create(ApartmentRequest request) {
        return null;
    }

    @Override
    public Apartment create(Long id, ApartmentRequest request) {
        Optional<Building> optBuilding =  buildingService.findById(id);
        if(optBuilding.isPresent()) {
            Building building = optBuilding.get();
            Apartment apartment = mapper.toApartment(request, building);
            save(apartment);
            return apartment;
        }
        throw new BuildingNotFoundException("Building not found.");
    }

    @Override
    public Boolean checkAvailabilityById(Long apartmentId) {
        Optional<Apartment> optApartment = findById(apartmentId);
        return optApartment.map(Apartment::isAvailable).orElse(false);
    }

    @Override
    public Tenant viewApartmentTenantById(Long apartmentId) {
        Optional<Apartment> optApartment = findById(apartmentId);
        return optApartment.map(Apartment::getTenant).orElse(null);

    }

    @Override
    public RentApartmentResponse rentApartment(Long apartmentId, LeaseAgreementRequest contractRequest) {
        Optional<Apartment> optApartment = findById(apartmentId);
        if(optApartment.isPresent()) {
            Apartment apartment = optApartment.get();
            RentApartmentResponse response = mapper.toRentApartmentResponse(apartment, contractRequest);
            repository.save(mapper.toApartment(response));
            return response;
        }
        throw new ApartmentNotFoundException("Apartment not found.");
    }

    @Override
    public Apartment save(Apartment apartment) {
        return repository.save(apartment);
    }

    @Override
    public Apartment delete(Long id) {
        Optional<Apartment> optionalApart = findById(id);
        if (optionalApart.isPresent()) {
            Apartment apartment = optionalApart.get();
            repository.delete(apartment);
            return apartment;
        }
        throw new ApartmentNotFoundException("Apartment not found.");
    }

}
