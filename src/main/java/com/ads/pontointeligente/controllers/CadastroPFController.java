package com.ads.pontointeligente.controllers;

import com.ads.pontointeligente.command.AddCadastroPfCommand;
import com.ads.pontointeligente.dtos.CadastroPFDto;
import com.ads.pontointeligente.entities.Funcionario;
import com.ads.pontointeligente.enums.PerfilEnum;
import com.ads.pontointeligente.response.Response;
import com.ads.pontointeligente.services.EmpresaService;
import com.ads.pontointeligente.services.FuncionarioService;
import com.ads.pontointeligente.utils.PasswordUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/cadastrar-pf")
@CrossOrigin(origins = "*")
public class CadastroPFController {

    // private static final Logger log = LoggerFactory.getLogger(CadastroPFController.class);

    private CommandGateway commandGateway;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private FuncionarioService funcionarioService;

    /**
     * Cadastra um funcionário pessoa física no sistema.
     *
     * @param cmd
  //   * @param result
     * @return ResponseEntity<Response < CadastroPFDto>>
     * @throws NoSuchAlgorithmException
     */
    @PostMapping
    public CompletableFuture<String> cadastrar(@Valid @RequestBody CadastroPFDto cmd) {
        log.info("Cadastrando PF: {}", cmd.toString());
       // var command = new AddCadastroPfCommand(UUID.randomUUID().toString(), cmd.getNome(), cmd.getEmail(), cmd.getSenha(), cmd.getCpf(), cmd.getValorHora(), cmd.getQtdHorasTrabalhoDia(), cmd.getQtdHorasAlmoco(), cmd.getCnpj());
        var command = new AddCadastroPfCommand(UUID.randomUUID().toString(), cmd.getNome());
        log.info("Executing command: {}", command);
        return commandGateway.send(command);
    }

   /* *//**
     * Verifica se a empresa está cadastrada e se o funcionário não existe na base de dados.
     *
     * @param cadastroPFDto
     * @param result
     *//*
    private void validarDadosExistentes(CadastroPFDto cadastroPFDto, BindingResult result) {
        var empresa = this.empresaService.buscarPorCnpj(cadastroPFDto.getCnpj());
        if (!empresa.isPresent()) {
            result.addError(new ObjectError("empresa", "Empresa não cadastrada."));
        }

        this.funcionarioService.buscarPorCpf(cadastroPFDto.getCpf())
                .ifPresent(func -> result.addError(new ObjectError("funcionario", "CPF já existente.")));

        this.funcionarioService.buscarPorEmail(cadastroPFDto.getEmail())
                .ifPresent(func -> result.addError(new ObjectError("funcionario", "Email já existente.")));
    }

    *//**
     * Converte os dados do DTO para funcionário.
     *
     * @param cadastroPFDto
     * @param result
     * @return Funcionario
     * @throws NoSuchAlgorithmException
     *//*
    private Funcionario converterDtoParaFuncionario(CadastroPFDto cadastroPFDto, BindingResult result)
            throws NoSuchAlgorithmException {
        var funcionario = new Funcionario();
        funcionario.setNome(cadastroPFDto.getNome());
        funcionario.setEmail(cadastroPFDto.getEmail());
        funcionario.setCpf(cadastroPFDto.getCpf());
        funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
        funcionario.setSenha(PasswordUtils.gerarBCrypt(cadastroPFDto.getSenha()));
        cadastroPFDto.getQtdHorasAlmoco()
                .ifPresent(qtdHorasAlmoco -> funcionario.setQtdHorasAlmoco(Float.valueOf(qtdHorasAlmoco)));
        cadastroPFDto.getQtdHorasTrabalhoDia()
                .ifPresent(qtdHorasTrabDia -> funcionario.setQtdHorasTrabalhoDia(Float.valueOf(qtdHorasTrabDia)));
        cadastroPFDto.getValorHora().ifPresent(valorHora -> funcionario.setValorHora(new BigDecimal(valorHora)));

        return funcionario;
    }

    *//**
     * Popula o DTO de cadastro com os dados do funcionário e empresa.
     *
     * @param funcionario
     * @return CadastroPFDto
     *//*
    private CadastroPFDto converterCadastroPFDto(Funcionario funcionario) {
        var cadastroPFDto = new CadastroPFDto();
        //cadastroPFDto.setId(funcionario.getId());
        cadastroPFDto.setNome(funcionario.getNome());
        cadastroPFDto.setEmail(funcionario.getEmail());
        cadastroPFDto.setCpf(funcionario.getCpf());
        cadastroPFDto.setCnpj(funcionario.getEmpresa().getCnpj());
        funcionario.getQtdHorasAlmocoOpt().ifPresent(qtdHorasAlmoco -> cadastroPFDto
                .setQtdHorasAlmoco(Optional.of(Float.toString(qtdHorasAlmoco))));
        funcionario.getQtdHorasTrabalhoDiaOpt().ifPresent(
                qtdHorasTrabDia -> cadastroPFDto.setQtdHorasTrabalhoDia(Optional.of(Float.toString(qtdHorasTrabDia))));
        funcionario.getValorHoraOpt()
                .ifPresent(valorHora -> cadastroPFDto.setValorHora(Optional.of(valorHora.toString())));

        return cadastroPFDto;
    }
*/
}
