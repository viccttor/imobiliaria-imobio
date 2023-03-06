package br.com.imobio.service.impl;

import br.com.imobio.mapper.BuildingMapper;
import br.com.imobio.model.entity.Building;
import br.com.imobio.model.repository.BuildingRepository;
import br.com.imobio.model.request.BuildingRequest;
import br.com.imobio.service.BuildingService;
import br.com.imobio.service.exception.BuildingNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository repository;
    private final BuildingMapper mapper;

    @Override
    public List<Building> listAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Building> findById(Long id) {
        Optional<Building> optBuilding = repository.findById(id);
        if (optBuilding.isPresent()) {
            return optBuilding;
        }
        throw new BuildingNotFoundException("Building not found.");
    }

    @Override
    public Building create(BuildingRequest request) {
        Building building = mapper.toBuilding(request);
        return repository.save(building);
    }

    @Override
    public Building save(Building building) {
        return repository.save(building);
    }

    @Override
    public Building delete(Long id) {
        Optional<Building> optBuilding = findById(id);
        if (optBuilding.isPresent()) {
            Building building = optBuilding.get();
            repository.delete(building);
            return building;
        }
        return null;
    }

}
