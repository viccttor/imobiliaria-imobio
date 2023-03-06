package br.com.imobio.controller;

import br.com.imobio.mapper.ApartmentMapper;
import br.com.imobio.model.entity.Apartment;
import br.com.imobio.model.entity.Tenant;
import br.com.imobio.model.request.ApartmentRequest;
import br.com.imobio.model.request.LeaseAgreementRequest;
import br.com.imobio.model.response.ApartmentResponse;
import br.com.imobio.model.response.RentApartmentResponse;
import br.com.imobio.service.ApartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Api(value = "Apartment Controller", tags = "apartmentController")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/apartment")
public class ApartmentController {

    private final ApartmentService apartmentService;
    private final ApartmentMapper mapper;

    @ApiOperation(value = "List all apartments")
    @GetMapping("/listAllApartments")
    public ResponseEntity<List<ApartmentResponse>> listAllApartments () {
        return ResponseEntity.ok().body(apartmentService.listAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList()));
    }

    @ApiOperation(value = "Find apartment by id")
    @GetMapping("/findApartmentById")
    public ResponseEntity<ApartmentResponse> findApartmentById (@RequestParam Long apartmentId) {
        Optional<Apartment> optApartment = apartmentService.findById(apartmentId);
        return optApartment.map(apartment -> ResponseEntity.ok().body(mapper.toResponse(apartment)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @ApiOperation(value = "Check apartment availability by id")
    @GetMapping("/checkAvailabilityById")
    public ResponseEntity<Boolean> checkAvailabilityById (@RequestParam Long apartmentId) {
        return ResponseEntity.ok().body(apartmentService.checkAvailabilityById(apartmentId));
    }

    @ApiOperation(value = "View Apartment Tenant by id")
    @GetMapping("/viewApartmentTenantById")
    public ResponseEntity<Tenant> viewApartmentTenantById (@RequestParam Long apartmentId) {
        return ResponseEntity.ok().body(apartmentService.viewApartmentTenantById(apartmentId));
    }

    @ApiOperation(value = "Rent an apartment")
    @PatchMapping("/rentApartment")
    public ResponseEntity<RentApartmentResponse> rentApartment(@RequestParam Long apartmentId,
                                                               @RequestBody LeaseAgreementRequest contractRequest) {
        return ResponseEntity.ok().body(apartmentService.rentApartment(apartmentId, contractRequest));
    }







    @ApiOperation(value = "Create apartment")
    @PostMapping("/createApartment")
    public ResponseEntity<ApartmentResponse> createApartment(@RequestParam Long buildingId, @RequestBody ApartmentRequest request) {
        Apartment apartment = apartmentService.create(buildingId, request);
        ApartmentResponse response = mapper.toResponse(apartment);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiOperation(value = "Delete apartment")
    @DeleteMapping("/deleteApartment")
    public ResponseEntity<ApartmentResponse> deleteApartment(@RequestParam Long apartmentId) {
        return ResponseEntity.ok().body(mapper.toResponse(apartmentService.delete(apartmentId)));
    }
}
