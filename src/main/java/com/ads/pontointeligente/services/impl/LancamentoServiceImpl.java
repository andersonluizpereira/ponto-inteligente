package com.ads.pontointeligente.services.impl;

import java.util.Optional;

import com.ads.pontointeligente.entities.Lancamento;
import com.ads.pontointeligente.repository.LancamentoRepository;
import com.ads.pontointeligente.services.LancamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class LancamentoServiceImpl implements LancamentoService {

    private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
        log.info("Buscando lançamentos para o funcionário ID {}", funcionarioId);
        return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
    }

    public Optional<Optional<Lancamento>> buscarPorId(Long id) {
        log.info("Buscando um lançamento pelo ID {}", id);
        return Optional.ofNullable(this.lancamentoRepository.findById(id));
    }

    public Lancamento persistir(Lancamento lancamento) {
        log.info("Persistindo o lançamento: {}", lancamento);
        return this.lancamentoRepository.save(lancamento);
    }

    public void remover(Long id) {
        log.info("Removendo o lançamento ID {}", id);
        this.lancamentoRepository.deleteById(id);
    }

}