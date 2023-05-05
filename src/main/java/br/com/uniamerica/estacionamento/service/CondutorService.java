package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.repository.CondutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CondutorService {
    @Autowired
    private CondutorRepository condutorRepository;

    @Transactional
    public void cadastraCondutor(Condutor condutor){
        if(condutor.getNome()==null || condutor.getNome().isEmpty()){
            throw new RuntimeException("Condutor não possui um nome (deve conter!)");
        }
        if(condutor.getCpf()==null || condutor.getCpf().isEmpty()){
            throw new RuntimeException("Condutor não possui um cpf (deve conter!)");
        }
        if(condutor.getTelefone()==null || condutor.getTelefone().isEmpty()){
            throw new RuntimeException("Condutor não possui um telefone (deve conter!)");
        }
        if(condutor.getNome().length() > 100){
            throw new RuntimeException("Nome de condutor excedeu o limite (100 caracteres!)");
        }
        if(condutor.getCpf().length() > 15){
            throw new RuntimeException("Cpf de condutor excedeu o limite (15 caracteres!)");
        }
        if(condutor.getTelefone().length() > 17){
            throw new RuntimeException("Telefone de condutor excedeu o limite (17 caracteres!)");
        }
        this.condutorRepository.save(condutor);
    }

    @Transactional
    public void atualizaCondutor(final Long id, Condutor condutor){
        final Condutor condutorBanco = this.condutorRepository.findById(id).orElse(null);
        if(condutorBanco==null || !condutorBanco.getId().equals(condutor.getId())){
            throw new RuntimeException("Não foi possivel encontrar o registro informado");
        }
        if(condutor.getNome()==null || condutor.getNome().isEmpty()){
            throw new RuntimeException("Condutor não possui um nome (deve conter!)");
        }
        if(condutor.getCpf()==null || condutor.getCpf().isEmpty()){
            throw new RuntimeException("Condutor não possui um cpf (deve conter!)");
        }
        if(condutor.getTelefone()==null || condutor.getTelefone().isEmpty()){
            throw new RuntimeException("Condutor não possui um telefone (deve conter!)");
        }
        this.condutorRepository.save(condutor);
    }

}
