package com.ads.pontointeligente.event;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Optional;

@Getter
@ToString
@AllArgsConstructor
public class AddCadastroPfEvent {
    private String id;
    private String nome;
   // private String email;
/*    private String senha;
    private String cpf;
    private Optional<String> valorHora = Optional.empty();
    private Optional<String> qtdHorasTrabalhoDia = Optional.empty();
    private Optional<String> qtdHorasAlmoco = Optional.empty();
    private String cnpj;*/
}
