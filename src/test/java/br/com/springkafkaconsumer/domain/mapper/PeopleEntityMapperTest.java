package br.com.springkafkaconsumer.domain.mapper;

import br.com.springkafkaconsumer.domain.model.Book;
import br.com.springkafkaconsumer.utils.MockUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PeopleEntityMapperTest {

    private final PeopleEntityMapper peopleEntityMapper = new PeopleEntityMapper();

    @Test
    void givenAPeopleDTOThenReturnPeopleEntity() {
        var peopleDTO = MockUtils.getPeopleDTO();

        var peopleEntity = peopleEntityMapper.toEntity(peopleDTO);
        assertThat(peopleEntity.getId()).isEqualTo(peopleDTO.getId());
        assertThat(peopleEntity.getName()).isEqualTo(peopleDTO.getName());
        assertThat(peopleEntity.getCpf()).isEqualTo(peopleDTO.getCpf());
        assertThat(peopleEntity.getBooks())
                .hasSize(1)
                .first()
                .satisfies(book -> assertBooks(book, peopleDTO.getBooks().get(0)));
    }

    private void assertBooks(Book book, String bookName) {
        assertThat(book.getName()).isEqualTo(bookName);
    }
}
