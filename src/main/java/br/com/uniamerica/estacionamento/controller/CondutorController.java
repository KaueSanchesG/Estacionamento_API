package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.repository.CondutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api/condutor")
public class CondutorController {
    @Autowired
    private CondutorRepository condutorRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id") final Long id){
        final Condutor condutor = this.condutorRepository.findById(id).orElse(null);
        return condutor==null ? ResponseEntity.badRequest().body("Nenhum valor encontrado") : ResponseEntity.ok(condutor);
    }
    @GetMapping
    public ResponseEntity<?> findByIdReques(@RequestParam("id") final Long id){
        final Condutor condutor = this.condutorRepository.findById(id).orElse(null);
        return condutor==null ? ResponseEntity.badRequest().body("Nenhum valor encontrado") : ResponseEntity.ok(condutor);
    }
    @GetMapping("/lista")
    public ResponseEntity<?> listaCompleta(){ return ResponseEntity.ok(this.condutorRepository.findAll());}
    @GetMapping("/ativo")
    public ResponseEntity<List<Condutor>> findByAtivo() {
        List<Condutor> condutores = condutorRepository.findByAtivo();
        return ResponseEntity.ok(condutores);
    }



    @PostMapping
    public  ResponseEntity<?> cadastrar(@RequestBody final Condutor condutor) {
        try {
            this.condutorRepository.save(condutor);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        }
        catch (DataIntegrityViolationException e) {
            return ResponseEntity.internalServerError().body("Erro " + e.getCause().getCause().getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestParam("id") final Long id, @RequestBody final Condutor condutor){
        try{
            final Condutor condutorBanco = this.condutorRepository.findById(id).orElse(null);
            if(condutorBanco == null || !condutorBanco.getId().equals(condutor.getId())){
                throw new RuntimeException("Não foi possivel identificar o registro informado");
            }
            this.condutorRepository.save(condutor);
            return ResponseEntity.ok("Registro atualizado com sucesso");
        }
        catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error " + e.getCause().getCause().getMessage());
        }
        catch(RuntimeException e){
            return ResponseEntity.internalServerError().body("Error" + e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<?> deletar(@RequestParam("id") final Long id){
        final Condutor condutorBanco = this.condutorRepository.findById(id).orElse(null);
        this.condutorRepository.delete(condutorBanco);
        return ResponseEntity.ok("Registro excluido com sucesso");
    }
}
