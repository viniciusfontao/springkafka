package br.com.springkafka.domain.usecase;

import br.com.springkafka.adapter.dto.PeopleDTO;
import br.com.springkafka.domain.usecase.port.PeoplePort;
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
