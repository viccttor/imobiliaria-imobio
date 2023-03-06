package br.com.imobio.model.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class AptOwnerResponse {
    private Long id;
    private String name;

}
