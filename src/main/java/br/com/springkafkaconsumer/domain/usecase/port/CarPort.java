package br.com.springkafkaconsumer.domain.usecase.port;

import br.com.springkafkaconsumer.adapter.dto.CarDTO;

public interface CarPort {

    void save(CarDTO carDTO);
}
