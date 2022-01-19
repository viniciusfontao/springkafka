package br.com.springkafka.domain.usecase.port;

import br.com.springkafka.adapter.dto.CarDTO;

public interface CarPort {

    void save(CarDTO carDTO);
}
