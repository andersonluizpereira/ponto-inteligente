package com.ads.pontointeligente.services.impl;

import java.util.Optional;

import com.ads.pontointeligente.entities.Funcionario;
import com.ads.pontointeligente.repository.FuncionarioRepository;
import com.ads.pontointeligente.services.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private static final Logger log = LoggerFactory.getLogger(FuncionarioServiceImpl.class);

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario persistir(Funcionario funcionario) {
        log.info("Persistindo funcionário: {}", funcionario);
        return this.funcionarioRepository.save(funcionario);
    }

    public Funcionario buscarPorCpf(String cpf) {
        log.info("Buscando funcionário pelo CPF {}", cpf);
        return this.funcionarioRepository.findByCpf(cpf);
    }

    public Funcionario buscarPorEmail(String email) {
        log.info("Buscando funcionário pelo email {}", email);
        return this.funcionarioRepository.findByEmail(email);
    }

    public Optional<Funcionario> buscarPorId(Long id) {
        log.info("Buscando funcionário pelo IDl {}", id);
        return this.funcionarioRepository.findById(id);
    }

}
