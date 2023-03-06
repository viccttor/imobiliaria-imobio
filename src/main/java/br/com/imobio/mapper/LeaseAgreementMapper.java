package br.com.imobio.mapper;

import br.com.imobio.model.entity.LeaseAgreement;
import br.com.imobio.model.request.LeaseAgreementRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LeaseAgreementMapper {

    private final ModelMapper mapper;

    public LeaseAgreement toLeaseAgreement(LeaseAgreementRequest request) {
        return  mapper.map(request, LeaseAgreement.class);
    }
}
