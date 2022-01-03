package br.com.springkafka.domain.mapper;

import br.com.springkafka.adapter.dto.PeopleDTO;
import br.com.springkafka.domain.model.People;
import org.springframework.stereotype.Component;

@Component
public class PeopleEntityMapper {

    public People toEntity(PeopleDTO peopleDTO) {
        return People.builder()
                .id(peopleDTO.getId())
                .cpf(peopleDTO.getCpf())
                .name(peopleDTO.getName())
                .build();
    }
}
