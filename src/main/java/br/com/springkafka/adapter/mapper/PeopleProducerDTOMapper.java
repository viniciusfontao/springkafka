package br.com.springkafka.adapter.mapper;

import br.com.springkafka.adapter.dto.PeopleProducerDTO;
import br.com.springkafka.adapter.dto.PeopleRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class PeopleProducerDTOMapper {

    public PeopleProducerDTO toDTO(PeopleRequestDTO peopleRequestDTO) {
        return PeopleProducerDTO.builder()
                .name(peopleRequestDTO.getName())
                .cpf(peopleRequestDTO.getCpf())
                .books(peopleRequestDTO.getBooks())
                .build();
    }
}
