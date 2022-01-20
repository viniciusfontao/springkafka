package br.com.springkafkaconsumer.adapter.gateway;

import br.com.springkafkaconsumer.adapter.dto.CarDTO;
import br.com.springkafkaconsumer.adapter.repository.CarRepository;
import br.com.springkafkaconsumer.domain.mapper.CarEntityMapper;
import br.com.springkafkaconsumer.domain.usecase.port.CarPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class CarGateway implements CarPort {

    private final CarRepository carRepository;
    private final CarEntityMapper carEntityMapper;

    @Override
    @Transactional
    public void save(CarDTO carDTO) {
        carRepository.save(carEntityMapper.toEntity(carDTO));
    }
}
