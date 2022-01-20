package br.com.springkafkaconsumer.domain.usecase;

import br.com.springkafkaconsumer.adapter.dto.CarDTO;
import br.com.springkafkaconsumer.domain.usecase.port.CarPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarConsumerUseCase {

    private final CarPort carPort;

    public void execute(CarDTO carDTO) {
        carPort.save(carDTO);
    }
}
