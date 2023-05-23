package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.config.ValidaCPF;
import br.com.uniamerica.estacionamento.config.ValidaPlaca;
import br.com.uniamerica.estacionamento.config.ValidaTelefone;
import br.com.uniamerica.estacionamento.entity.Configuracao;
import br.com.uniamerica.estacionamento.entity.Movimentacao;
import br.com.uniamerica.estacionamento.repository.ConfiguracaoRepository;
import br.com.uniamerica.estacionamento.repository.MovimentacaoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;
    @Autowired
    private ValidaCPF validaCPF;
    @Autowired
    private ConfiguracaoRepository configuracaoRepository;

    @Transactional
    public void cadastraMovimentacao(Movimentacao movimentacao){
        if(movimentacao.getId()!=null){
            throw new RuntimeException("O id deve ser gerado pelo banco");
        }
        if("".equals(movimentacao.getEntrada())){
            throw new RuntimeException("A movimentação não possui uma entrada (deve conter!)");
        }
        if(movimentacao.getSaida() != null){
            LocalTime tempo = movimentacao.getSaida()
                    .minusHours(movimentacao.getEntrada().getHour())
                    .minusMinutes(movimentacao.getEntrada().getMinute())
                    .minusSeconds(movimentacao.getEntrada().getSecond());
            movimentacao.setTempo(tempo);
        }
        if(movimentacao.getEntrada().isBefore(configuracaoRepository.findInicioExpediente())){
            Duration tempoMulta = Duration.between(configuracaoRepository.findInicioExpediente(), movimentacao.getEntrada());
            movimentacao.setValorMinutoMulta(configuracaoRepository.findValorMinutoMulta());
            movimentacao.setTempoMulta(tempoMulta.toMinutes());
        }
        if(movimentacao.getSaida().isAfter(configuracaoRepository.findFimExpediente())){
            Duration tempoMulta = Duration.between(movimentacao.getEntrada(), movimentacao.getSaida());
            movimentacao.setValorMinutoMulta(configuracaoRepository.findValorMinutoMulta());
            movimentacao.setTempoMulta(movimentacao.getTempoMulta() + tempoMulta.toMinutes());
        }
        if(movimentacao.getTempoMulta()!=null){
            movimentacao.setValorMulta(movimentacao.getValorMinutoMulta().multiply(BigDecimal.valueOf(movimentacao.getTempoMulta())));
        }
        if(movimentacao.getTempo()!=null) {
            movimentacao.setValorHora(configuracaoRepository.findValorHora());
            BigDecimal valorTotal = configuracaoRepository.findValorHora().multiply(new BigDecimal(movimentacao.getTempo().getHour()));
            movimentacao.setValorTotal(valorTotal);
        }

        this.movimentacaoRepository.save(movimentacao);
    }

    @Transactional
    public void atuaizaMovimentacao(final Long id, Movimentacao movimentacao){
        final Movimentacao movimentacaoBanco = this.movimentacaoRepository.findById(id).orElse(null);
        if(movimentacaoBanco==null || !movimentacaoBanco.getId().equals(movimentacao.getId())){
            throw new RuntimeException("Não foi possivel encontrar o registro informado");
        }
        if(movimentacao.getVeiculo()==null){
            throw new RuntimeException("O id de veiculo está incorreto");
        }
        if(movimentacao.getCondutor()==null){
            throw new RuntimeException("O id de condutor está incoreto");
        }
        if("".equals(movimentacao.getEntrada())){
            throw new RuntimeException("A movimentação não possui uma entrada (deve conter!)");
        }
        if(movimentacao.getSaida() != null){
            LocalTime tempo = movimentacao.getSaida()
                    .minusHours(movimentacao.getEntrada().getHour())
                    .minusMinutes(movimentacao.getEntrada().getMinute())
                    .minusSeconds(movimentacao.getEntrada().getSecond());
            movimentacao.setTempo(tempo);
        }
        if (movimentacao.getEntrada()!=null && movimentacao.getEntrada().isBefore(configuracaoRepository.findInicioExpediente())) {
            Duration tempoMulta = Duration.between(configuracaoRepository.findInicioExpediente(), movimentacao.getEntrada());
            movimentacao.setValorMinutoMulta(configuracaoRepository.findValorMinutoMulta());
            movimentacao.setTempoMulta(tempoMulta.toMinutes());
        }
        if (movimentacao.getSaida() != null && movimentacao.getSaida().isAfter(configuracaoRepository.findFimExpediente())) {
            Duration tempoMulta = Duration.between(movimentacao.getEntrada(), movimentacao.getSaida());
            movimentacao.setValorMinutoMulta(configuracaoRepository.findValorMinutoMulta());
            movimentacao.setTempoMulta(movimentacao.getTempoMulta().longValue() + tempoMulta.toMinutes());
        }
        if(movimentacao.getTempoMulta()!=null){
            movimentacao.setValorMulta(movimentacao.getValorMinutoMulta().multiply(BigDecimal.valueOf(movimentacao.getTempoMulta())));
        }
        if(movimentacao.getTempo()!=null) {
            movimentacao.setValorHora(configuracaoRepository.findValorHora());
            BigDecimal valorTotal = configuracaoRepository.findValorHora().multiply(new BigDecimal(movimentacao.getTempo().getHour()));
            movimentacao.setValorTotal(valorTotal);
        }

        this.movimentacaoRepository.save(movimentacao);
    }
}
