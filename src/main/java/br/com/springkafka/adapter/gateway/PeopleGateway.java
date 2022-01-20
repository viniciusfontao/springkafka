package br.com.springkafka.adapter.gateway;

import br.com.springkafka.adapter.dto.PeopleDTO;
import br.com.springkafka.adapter.repository.PeopleRepository;
import br.com.springkafka.domain.mapper.PeopleEntityMapper;
import br.com.springkafka.domain.usecase.port.PeoplePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class PeopleGateway implements PeoplePort {

    private final PeopleRepository peopleRepository;

    private final PeopleEntityMapper peopleEntityMapper;

    @Transactional
    @Override
    public void save(PeopleDTO peopleDTO) {
        peopleRepository.save(peopleEntityMapper.toEntity(peopleDTO));
    }
}
