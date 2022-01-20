package br.com.springkafkaconsumer.adapter.repository;

import br.com.springkafkaconsumer.domain.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, String> {
}