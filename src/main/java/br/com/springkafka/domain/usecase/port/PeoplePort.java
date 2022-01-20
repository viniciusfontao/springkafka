package br.com.springkafka.domain.usecase.port;

import br.com.springkafka.adapter.dto.PeopleDTO;

public interface PeoplePort {

    void save(PeopleDTO people);
}
