package br.com.fiap.bots.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.bots.model.Segment;

@Repository
public interface SegmentRepository extends CrudRepository<Segment, Long> {
	Segment findById(long id_segment);
	
}
