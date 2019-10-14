package com.ads.pontointeligente.aggregate;

import com.ads.pontointeligente.command.AddCadastroPfCommand;
import com.ads.pontointeligente.event.AddCadastroPfEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Slf4j
@Getter
@Aggregate
@NoArgsConstructor
public class AddCadastroPfAccountAggregate {

    @AggregateIdentifier
    private String id;
    private String nome;
   // private String email;
    private String senha;
    private String cpf;
    private Optional<String> valorHora = Optional.empty();
    private Optional<String> qtdHorasTrabalhoDia = Optional.empty();
    private Optional<String> qtdHorasAlmoco = Optional.empty();
    private String cnpj;


    @CommandHandler
    public AddCadastroPfAccountAggregate(AddCadastroPfCommand cmd) {
        log.info("Handling {} command: {}", cmd.getClass().getSimpleName(), cmd);
 //       Assert.hasLength(cmd.getCpf(), "Id should not be empty or null.");
        Assert.hasLength(cmd.getNome(), "Name should not be empty or null.");

   //     AggregateLifecycle.apply(new AddCadastroPfEvent(cmd.getId(), cmd.getNome(), cmd.getEmail(), cmd.getSenha(), cmd.getCpf(), cmd.getValorHora(), cmd.getQtdHorasTrabalhoDia(), cmd.getQtdHorasAlmoco(), cmd.getCnpj()));
        apply(new AddCadastroPfEvent(cmd.getId(), cmd.getNome()));
        log.info("Done handling {} command: {}", cmd.getClass().getSimpleName(), cmd);
    }

    @EventSourcingHandler
    public void on(AddCadastroPfEvent event) {
        log.info("Handling {} event: {}", event.getClass().getSimpleName(), event);
        this.id = event.getId();
        this.nome = event.getNome();
 //       this.cnpj  = event.getCnpj();
 //       this.cpf  = event.getCpf();
        //this.email  = event.getEmail();
 //       this.qtdHorasAlmoco  = event.getQtdHorasAlmoco();
 //       this.qtdHorasTrabalhoDia  = event.getQtdHorasTrabalhoDia();
 //       this.valorHora  = event.getValorHora();
        log.info("Done handling {} event: {}", event.getClass().getSimpleName(), event);
    }

}
