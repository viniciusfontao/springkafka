package br.com.springkafka.adapter.mapper;

import org.junit.jupiter.api.Test;

import static br.com.springkafka.utils.MockUtils.getPeopleAvro;
import static org.assertj.core.api.Assertions.assertThat;

public class PeopleDTOMapperTest {

    private final PeopleDTOMapper peopleDTOMapper = new PeopleDTOMapper();

    @Test
    void givenAPeopleAvroThenReturnPeopleDTO() {
        var peopleAvro = getPeopleAvro();

        var peopleDTO = peopleDTOMapper.toDTO(peopleAvro);

        assertThat(peopleDTO.getId()).isEqualTo(peopleAvro.getId());
        assertThat(peopleDTO.getName()).isEqualTo(peopleAvro.getName());
        assertThat(peopleDTO.getCpf()).isEqualTo(peopleAvro.getCpf());
        assertThat(peopleDTO.getBooks())
                .hasSize(1)
                .first()
                .satisfies(book -> assertBooks(book, peopleAvro.getBooks().get(0)));
    }

    private void assertBooks(String book, CharSequence bookCharSequence) {
        assertThat(book).isEqualTo(bookCharSequence);
    }


}
