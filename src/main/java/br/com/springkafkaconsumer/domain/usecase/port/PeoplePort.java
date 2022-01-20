package br.com.springkafkaconsumer.domain.usecase.port;

import br.com.springkafkaconsumer.adapter.dto.PeopleDTO;

public interface PeoplePort {

    void save(PeopleDTO people);
}
