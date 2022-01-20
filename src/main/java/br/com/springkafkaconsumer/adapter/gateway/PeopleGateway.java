package br.com.springkafkaconsumer.adapter.gateway;

import br.com.springkafkaconsumer.adapter.dto.PeopleDTO;
import br.com.springkafkaconsumer.adapter.repository.PeopleRepository;
import br.com.springkafkaconsumer.domain.mapper.PeopleEntityMapper;
import br.com.springkafkaconsumer.domain.usecase.port.PeoplePort;
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
