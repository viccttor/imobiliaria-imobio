package br.com.imobio.controller;

import br.com.imobio.mapper.BuildingMapper;
import br.com.imobio.model.entity.Building;
import br.com.imobio.model.request.BuildingRequest;
import br.com.imobio.model.response.BuildingResponse;
import br.com.imobio.service.BuildingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Api(value = "Building Controller", tags = "buildingController")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/building")
public class BuildingController {
    private final BuildingService service;
    private final BuildingMapper mapper;

    @ApiOperation(value = "List all buildings")
    @GetMapping("/listAllBuildings")
    public ResponseEntity<List<BuildingResponse>> listAllBuildings () {
        return ResponseEntity.ok().body(service.listAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList()));
    }

    @ApiOperation(value = "Find a building by id")
    @GetMapping("/findBuildingById")
    public ResponseEntity<BuildingResponse> findBuildingById (@RequestParam Long buildingId) {
        Optional<Building> optBuilding = service.findById(buildingId);
        return optBuilding.map(building -> ResponseEntity.ok().body(mapper.toResponse(building)))
                .orElseGet(() -> ResponseEntity.ok().body(null));
    }

    @ApiOperation(value = "Create a building")
    @PostMapping("/createBuilding")
    public ResponseEntity<BuildingResponse> createBuilding(@RequestBody BuildingRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(service.create(request)));
    }

    @ApiOperation(value = "Delete a building")
    @DeleteMapping("/deleteBuilding")
    public ResponseEntity<BuildingResponse> deleteBuilding(@RequestParam Long buildingId) {
        return ResponseEntity.ok().body(mapper.toResponse(service.delete(buildingId)));
    }
}
