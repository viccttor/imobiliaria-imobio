package br.com.imobio.mapper;

import br.com.imobio.model.entity.Tenant;
import br.com.imobio.model.request.TenantRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TenantMapper {

    private final ModelMapper mapper;

    public Tenant toTenantRequest(TenantRequest request) {
        return mapper.map(request,Tenant.class);
    }
}
