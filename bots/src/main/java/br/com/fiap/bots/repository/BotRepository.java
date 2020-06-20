package br.com.fiap.bots.repository;
import br.com.fiap.bots.model.Bot;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BotRepository extends CrudRepository<Bot, Long> {
	Bot findById(long id_bot);
}
