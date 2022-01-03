package br.com.springkafka.adapter.gateway;

import br.com.springkafka.adapter.repository.PeopleRepository;
import br.com.springkafka.domain.model.People;
import br.com.springkafka.domain.usecase.port.PeoplePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class PeopleGateway implements PeoplePort {

    private final PeopleRepository peopleRepository;

    @Transactional
    @Override
    public void save(People people) {
        peopleRepository.save(people);
    }
}
