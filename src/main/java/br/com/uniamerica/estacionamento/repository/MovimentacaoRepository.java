package br.com.uniamerica.estacionamento.repository;

import br.com.uniamerica.estacionamento.entity.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    public List<Movimentacao> findByAbertas(@Param("saida") final LocalDateTime saida);
    @Query("SELECT x FROM Movimentacao x WHERE x.ativo = true")
    List<Movimentacao> findByAtivo();
}
