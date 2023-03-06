package br.com.imobio.mapper;

import br.com.imobio.model.entity.AptOwner;
import br.com.imobio.model.request.AptOwnerRequest;
import br.com.imobio.model.response.AptOwnerResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AptOwnerMapper {

    private final ModelMapper mapper;

    public AptOwnerResponse toResponse(AptOwner aptOwner) {
        return mapper.map(aptOwner, AptOwnerResponse.class);
    }
    public AptOwner toAptOwner(AptOwnerRequest request) {
        return mapper.map(request, AptOwner.class);
    }
}
