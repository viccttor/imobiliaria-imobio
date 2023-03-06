package br.com.imobio.service.impl;

import br.com.imobio.mapper.LeaseAgreementMapper;
import br.com.imobio.model.entity.LeaseAgreement;
import br.com.imobio.model.repository.LeaseAgreementRepository;
import br.com.imobio.model.request.LeaseAgreementRequest;
import br.com.imobio.service.LeaseAgreementService;
import br.com.imobio.service.exception.LeaseAgreementNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class LeaseAgreementServiceImpl implements LeaseAgreementService {

    private final LeaseAgreementRepository repository;
    private final LeaseAgreementMapper mapper;
    @Override
    public List<LeaseAgreement> listAll() {
        return repository.findAll();
    }

    @Override
    public Optional<LeaseAgreement> findById(Long id) {
        Optional<LeaseAgreement> optionalRentContract = repository.findById(id);
        if (optionalRentContract.isPresent()) {
            return optionalRentContract;
        }
        throw new LeaseAgreementNotFoundException("Lease agreement not found.");
    }

    @Override
    public LeaseAgreement create(LeaseAgreementRequest request) {
        return repository.save(mapper.toLeaseAgreement(request));
    }

    @Override
    public LeaseAgreement save(LeaseAgreement entity) {
        return repository.save(entity);
    }

    @Override
    public LeaseAgreement delete(Long id) {
        Optional<LeaseAgreement> optional = findById(id);
        if (optional.isPresent()) {
            LeaseAgreement leaseAgreement = optional.get();
            repository.delete(leaseAgreement);
            return leaseAgreement;
        }
        throw new LeaseAgreementNotFoundException("Lease agreement not found.");
    }

}
