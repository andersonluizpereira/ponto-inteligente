package com.ads.pontointeligente.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Optional;

@Getter
@ToString
@AllArgsConstructor
public class AddCadastroPfCommand {
    @TargetAggregateIdentifier
    private String id;
    private String nome;
  //  private String email;
/*    private String senha;
    private String cpf;
    private Optional<String> valorHora = Optional.empty();
    private Optional<String> qtdHorasTrabalhoDia = Optional.empty();
    private Optional<String> qtdHorasAlmoco = Optional.empty();
    private String cnpj;*/
}
