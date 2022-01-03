package br.com.springkafka.domain.usecase.port;

import br.com.springkafka.domain.model.People;

public interface PeoplePort {

    void save(People people);
}
