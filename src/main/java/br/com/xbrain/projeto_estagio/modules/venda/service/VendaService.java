package br.com.xbrain.projeto_estagio.modules.venda.service;

import br.com.xbrain.projeto_estagio.modules.venda.model.Venda;
import br.com.xbrain.projeto_estagio.modules.venda.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Transactional
    public void registrar(Venda venda) {
        venda.setData(LocalDateTime.now());
        vendaRepository.save(venda);
    }

}
