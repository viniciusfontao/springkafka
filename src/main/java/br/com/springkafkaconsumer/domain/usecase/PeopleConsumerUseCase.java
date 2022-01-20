package br.com.springkafkaconsumer.domain.usecase;

import br.com.springkafkaconsumer.adapter.dto.PeopleDTO;
import br.com.springkafkaconsumer.domain.usecase.port.PeoplePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PeopleConsumerUseCase {

    private final PeoplePort peoplePort;

    public void execute(PeopleDTO peopleDTO) {
        peoplePort.save(peopleDTO);
    }
}
