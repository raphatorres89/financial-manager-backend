package br.com.raphaowl.financialmanager.repositories;

import br.com.raphaowl.financialmanager.documents.Movimento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovimentoRepository extends MongoRepository<Movimento, String> {
}
