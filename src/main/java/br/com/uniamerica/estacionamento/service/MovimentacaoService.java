package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Movimentacao;
import br.com.uniamerica.estacionamento.repository.MovimentacaoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Transactional
    public void cadastraMovimentacao(Movimentacao movimentacao){
        if(movimentacao.getVeiculo().getPlaca()==null || movimentacao.getVeiculo().getPlaca().isEmpty()){
            throw new RuntimeException("O veiculo da movimentação não possui placa (deve conter!)");
        }
        if(movimentacao.getVeiculo().getModelo().getNome()==null || movimentacao.getVeiculo().getModelo().getNome().isEmpty()){
            throw new RuntimeException("O veiculo da movimentação não possui nome de modelo (deve conter!)");
        }
        if(movimentacao.getVeiculo().getModelo().getMarca().getNome()==null || movimentacao.getVeiculo().getModelo().getMarca().getNome().isEmpty()){
            throw new RuntimeException("O veiculo da movimentação não possui nome de marca em modelo (deve conter!)");
        }
        if("".equals(movimentacao.getVeiculo().getAno())){
            throw new RuntimeException("O veiculo não possui um ano (deve conter!)");
        }
        if("".equals(movimentacao.getCondutor().getNome())){
            throw new RuntimeException("O condutor da movimentação não possui um nome (deve conter!)");
        }
        if("".equals(movimentacao.getCondutor().getCpf())){
            throw new RuntimeException("O condutor da movimentação não possui um cpf (deve conter!)");
        }
        if("".equals(movimentacao.getEntrada())){
            throw new RuntimeException("A movimentação não possui uma entrada (deve conter!)");
        }
        /*if("".equals(movimentacao.getVeiculo().getCor())){
            throw new RuntimeException("O veiculo da movimentação não possui uma cor (deve conter!)");
        }
        if(movimentacao.getVeiculo().getTipo()==null || movimentacao.getVeiculo().getTipo().describeConstable().isEmpty()){
            throw new RuntimeException("O veiculo da movimentação não possui uma cor (deve conter!)");
        }*/
        this.movimentacaoRepository.save(movimentacao);
    }

    @Transactional
    public void atuaizaMovimentacao(final Long id, Movimentacao movimentacao){
        final Movimentacao movimentacaoBanco = this.movimentacaoRepository.findById(id).orElse(null);
        if(movimentacaoBanco==null || !movimentacaoBanco.getId().equals(movimentacao.getId())){
            throw new RuntimeException("Não foi possivel encontrar o registro informado");
        }
        if(movimentacao.getVeiculo().getPlaca()==null || movimentacao.getVeiculo().getPlaca().isEmpty()){
            throw new RuntimeException("O veiculo da movimentação não possui placa (deve conter!)");
        }
        if(movimentacao.getVeiculo().getModelo().getNome()==null || movimentacao.getVeiculo().getModelo().getNome().isEmpty()){
            throw new RuntimeException("O veiculo da movimentação não possui nome de modelo (deve conter!)");
        }
        if(movimentacao.getVeiculo().getModelo().getMarca().getNome()==null || movimentacao.getVeiculo().getModelo().getMarca().getNome().isEmpty()){
            throw new RuntimeException("O veiculo da movimentação não possui nome de marca em modelo (deve conter!)");
        }
        if("".equals(movimentacao.getVeiculo().getAno())){
            throw new RuntimeException("O veiculo não possui um ano (deve conter!)");
        }
        if("".equals(movimentacao.getCondutor().getNome())){
            throw new RuntimeException("O condutor da movimentação não possui um nome (deve conter!)");
        }
        if("".equals(movimentacao.getCondutor().getCpf())){
            throw new RuntimeException("O condutor da movimentação não possui um cpf (deve conter!)");
        }
        if("".equals(movimentacao.getEntrada())){
            throw new RuntimeException("A movimentação não possui uma entrada (deve conter!)");
        }
        this.movimentacaoRepository.save(movimentacao);
    }
}
