package br.com.springkafka.domain.usecase;

import br.com.springkafka.adapter.dto.CarDTO;
import br.com.springkafka.domain.usecase.port.CarPort;
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
