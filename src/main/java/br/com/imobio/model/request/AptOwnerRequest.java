package br.com.imobio.model.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class AptOwnerRequest {

    @NotBlank(message = "Required field")
    private String name;
}
