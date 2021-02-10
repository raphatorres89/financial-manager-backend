package br.com.raphaowl.financialmanager.services;

import br.com.raphaowl.financialmanager.documents.Movimento;
import br.com.raphaowl.financialmanager.repositories.MovimentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class MovimentoService {

    @Autowired
    private MovimentoRepository movimentoRepository;

    public List<Movimento> findAll() {
        log.info("Buscando todos os movimentos");
        return movimentoRepository.findAll();
    }

    public Movimento save(Movimento movimento) {
        log.info("Salvando movimento: {}", movimento);
        return movimentoRepository.save(movimento);
    }

    public Movimento findById(String id) {
        log.info("Buscando movimento pelo id: {}", id);
        return movimentoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void delete(Movimento movimento) {
        log.info("Deletando movimento: {}", movimento);
        movimentoRepository.delete(movimento);
    }

    public List<Movimento> findByYearMonth(Integer year, Integer month) {
        log.info("Buscando movimento pelo mês {}, ano {}", month, year);
        return movimentoRepository.findByYearMonth(year, month);
    }
}
