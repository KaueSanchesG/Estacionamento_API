package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Configuracao;
import br.com.uniamerica.estacionamento.repository.ConfiguracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/configuracao")
public class ConfiguracaoController {
    @Autowired
    private ConfiguracaoRepository configuracaoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id") Long id){
        final Configuracao configuracao = this.configuracaoRepository.findById(id).orElse(null);
        return configuracao==null ? ResponseEntity.badRequest().body("Nenhum valor encontrado") : ResponseEntity.ok(configuracao);
    }
    @GetMapping
    public ResponseEntity<?> findByIdRequest(@RequestParam("id") Long id){
        final Configuracao configuracao = this.configuracaoRepository.findById(id).orElse(null);
        return configuracao==null ? ResponseEntity.badRequest().body("Nenhum valor encontrado") : ResponseEntity.ok(configuracao);
    }
    @GetMapping("/lista")
    public ResponseEntity<?> listaCompleta(){return ResponseEntity.ok(this.configuracaoRepository.findAll());}

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Configuracao configuracao){
        try {
            this.configuracaoRepository.save(configuracao);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        }
        catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error " + e.getCause().getCause().getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestParam("id") Long id, @RequestBody Configuracao configuracao){
        try {
            final Configuracao configuracaoBanco = this.configuracaoRepository.findById(id).orElse(null);
            if(configuracaoBanco==null || !configuracaoBanco.getId().equals(configuracao.getId())){
                throw new RuntimeException("Não foi possivel identificar o registro informado");
            }
            this.configuracaoRepository.save(configuracao);
            return ResponseEntity.ok("Registro atualizado com sucesso");
        }
        catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error " + e.getCause().getCause().getMessage());
        }
        catch(RuntimeException e){
            return ResponseEntity.internalServerError().body("Error " + e.getMessage());
        }
    }
}
