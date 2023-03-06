package br.com.imobio.service.impl;

import br.com.imobio.mapper.TenantMapper;
import br.com.imobio.model.entity.LeaseAgreement;
import br.com.imobio.model.entity.Tenant;
import br.com.imobio.model.repository.TenantRepository;
import br.com.imobio.model.request.TenantRequest;
import br.com.imobio.service.TenantService;
import br.com.imobio.service.exception.LeaseAgreementNotFoundException;
import br.com.imobio.service.exception.TenantNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class TenantServiceImpl implements TenantService {

    private final TenantRepository repository;
    private final TenantMapper mapper;

    @Override
    public List<Tenant> listAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Tenant> findById(Long id) {
        Optional<Tenant> optional = findById(id);
        if (optional.isPresent()) {

            return optional;
        }
        throw new TenantNotFoundException("Tenant not found.");
    }

    @Override
    public Tenant create(TenantRequest request) {
        return repository.save(mapper.toTenantRequest(request));
    }

    @Override
    public Tenant save(Tenant entity) {
        return repository.save(entity);
    }

    @Override
    public Tenant delete(Long id) {
        Optional<Tenant> optional = findById(id);
        if (optional.isPresent()) {
            Tenant tenant = optional.get();
            repository.delete(tenant);
            return tenant;
        }
        throw new TenantNotFoundException("Tenant not found.");
    }
}
