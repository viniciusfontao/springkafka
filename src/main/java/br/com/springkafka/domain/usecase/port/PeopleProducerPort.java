package br.com.springkafka.domain.usecase.port;

import br.com.springkafka.adapter.dto.PeopleProducerDTO;

public interface PeopleProducerPort {

    void publish(PeopleProducerDTO peopleProducerDTO);
}
