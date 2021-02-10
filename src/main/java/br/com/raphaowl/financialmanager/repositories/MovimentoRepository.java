package br.com.raphaowl.financialmanager.repositories;

import br.com.raphaowl.financialmanager.documents.Movimento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MovimentoRepository extends MongoRepository<Movimento, String> {

    @Query("{$expr:{$and:[{$eq:[{$year:'$vencimento'}, ?0]}, {$eq:[{$month:'$vencimento'}, ?1]}]}}")
    List<Movimento> findByYearMonth(int year, int month);

}
