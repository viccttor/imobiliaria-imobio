package br.com.imobio.service;

import br.com.imobio.model.entity.Apartment;
import br.com.imobio.model.entity.Tenant;
import br.com.imobio.model.request.ApartmentRequest;
import br.com.imobio.model.request.LeaseAgreementRequest;
import br.com.imobio.model.response.RentApartmentResponse;

public interface ApartmentService extends CrudService<Apartment, ApartmentRequest> {

    Apartment create(Long id, ApartmentRequest request);

    Boolean checkAvailabilityById(Long apartmentId);

    Tenant viewApartmentTenantById(Long apartmentId);

    RentApartmentResponse rentApartment(Long apartmentId, LeaseAgreementRequest contractRequest);
}
