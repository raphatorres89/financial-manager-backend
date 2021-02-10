package br.com.raphaowl.financialmanager.api.v1;

import br.com.raphaowl.financialmanager.api.v1.dto.MovimentoDTO;
import br.com.raphaowl.financialmanager.api.v1.mapper.MovimentoMapper;
import br.com.raphaowl.financialmanager.documents.Movimento;
import br.com.raphaowl.financialmanager.services.MovimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movimentos")
@CrossOrigin(origins = {"http://localhost:3000"})
public class MovimentoApi {

    @Autowired
    private MovimentoService movimentoService;

    @GetMapping
    public List<MovimentoDTO> findByYearMonth(@RequestParam Integer year, @RequestParam Integer month) {
        return movimentoService.findByYearMonth(year, month)
                .stream()
                .map(MovimentoMapper::from)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovimentoDTO save(@RequestBody MovimentoDTO movimentoDTO) {
        return MovimentoMapper.from(movimentoService.save(MovimentoMapper.to(movimentoDTO)));
    }

    @PutMapping("/{id}")
    public MovimentoDTO update(@RequestBody MovimentoDTO movimentoDTO, @PathVariable String id) {
        movimentoService.findById(id);

        Movimento movimentoAtualizado = MovimentoMapper.to(movimentoDTO);
        movimentoAtualizado.setId(id);

        return MovimentoMapper.from(movimentoService.save(movimentoAtualizado));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        movimentoService.delete(movimentoService.findById(id));
    }

}
