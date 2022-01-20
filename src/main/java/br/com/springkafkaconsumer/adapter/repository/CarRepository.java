package br.com.springkafkaconsumer.adapter.repository;

import br.com.springkafkaconsumer.domain.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
}
