package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Modelo;
import br.com.uniamerica.estacionamento.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModeloService {
    @Autowired
    private ModeloRepository modeloRepository;

    @Transactional
    public void cadastraModelo(Modelo modelo){
        if("".equals(modelo.getMarca().getNome())){
            throw new RuntimeException("A marca de modelo não possui nome (deve conter!)");
        }
        if("".equals(modelo.getNome())){
            throw new RuntimeException("O modelo não possui um nome (deve conter!)");
        }
        this.modeloRepository.save(modelo);
    }

    @Transactional
    public void atualizaModelo(final Long id, Modelo modelo){
        final Modelo modeloBanco = this.modeloRepository.findById(id).orElse(null);
        if(modeloBanco==null || !modeloBanco.getId().equals(modelo.getId())){
            throw new RuntimeException("Não foi possivel encontrar o registro informado");
        }
        if("".equals(modelo.getMarca().getNome())){
            throw new RuntimeException("A marca de modelo não possui nome (deve conter!)");
        }
        if("".equals(modelo.getNome())){
            throw new RuntimeException("O modelo não possui um nome (deve conter!)");
        }
        if(modelo.getNome().length()>50){
            throw new RuntimeException("Nome de modelo excedeu o limite (50 caracteres!)");
        }
        this.modeloRepository.save(modelo);
    }
}
