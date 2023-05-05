package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import java.math.BigDecimal;
import java.time.LocalTime;
@Entity
@Audited
@Table(name = "tb_configuracao", schema = "estacionamento")
@AuditTable(value = "tb_configuracao_audit", schema = "audit")
public class Configuracao extends AbstractEntity{
    @Getter@Setter
    @Column(name = "valorHora", nullable = false)
    private BigDecimal valorHora;
    @Getter@Setter
    @Column(name = "valorMinutoMulta")
    private BigDecimal valorMinutoMulta;
    @Getter@Setter
    @Column(name = "inicioExpediente")
    private LocalTime inicioExpediente;
    @Getter@Setter
    @Column(name = "fimExpediente")
    private LocalTime fimExpediente;
    @Getter@Setter
    @Column(name = "tempoParaDesconto")
    private LocalTime tempoParaDesconto;
    @Getter@Setter
    @Column(name = "tempoDeDesconto")
    private LocalTime tempoDeDesconto;
    @Getter@Setter
    @Column(name = "gerarDesconto")
    private boolean gerarDesconto;
    @Getter@Setter
    @Column(name = "vagasMoto", nullable = false)
    private int vagasMoto;
    @Getter@Setter
    @Column(name = "vagasCarro", nullable = false)
    private int vagasCarro;
    @Getter@Setter
    @Column(name = "vagasVan", nullable = false)
    private int vagasVan;
}
