package br.com.springkafka.domain.usecase;

import br.com.springkafka.adapter.dto.PeopleProducerDTO;
import br.com.springkafka.domain.usecase.port.PeopleProducerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PeopleProducerUseCase {

    private final PeopleProducerPort peopleProducerPort;

    public void execute(PeopleProducerDTO peopleProducerDTO) {
        peopleProducerPort.publish(peopleProducerDTO);
    }
}
