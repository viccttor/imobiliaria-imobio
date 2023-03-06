package br.com.imobio.service.impl;

import br.com.imobio.mapper.AptOwnerMapper;
import br.com.imobio.model.entity.AptOwner;
import br.com.imobio.model.repository.AptOwnerRepository;
import br.com.imobio.model.request.AptOwnerRequest;
import br.com.imobio.service.AptOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class AptOwnerServiceImpl implements AptOwnerService{

    private final AptOwnerRepository repository;
    private final AptOwnerMapper mapper;

    @Override
    public List<AptOwner> listAll() {
        return repository.findAll();
    }

    @Override
    public Optional<AptOwner> findById(Long id) {
        Optional<AptOwner> optionalAptOwner = repository.findById(id);
        System.out.println(repository.findAll());
        return optionalAptOwner;
    }

    @Override
    public AptOwner create(AptOwnerRequest request) {
        return repository.save(mapper.toAptOwner(request));
    }

    @Override
    public AptOwner save(AptOwner entity) {
        return repository.save(entity);
    }

    @Override
    public AptOwner delete(Long id) {
        Optional<AptOwner> optionalAptOwner = findById(id);
        if (optionalAptOwner.isPresent()) {
            AptOwner aptOwner = optionalAptOwner.get();
            repository.delete(aptOwner);
            return aptOwner;
        }
        return null;
    }
}
