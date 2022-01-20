package br.com.springkafkaconsumer.adapter.consumer;

import br.com.springkafkaconsumer.adapter.mapper.CarDTOMapper;
import br.com.springkafkaconsumer.domain.usecase.CarConsumerUseCase;
import br.com.springkafkaproducer.CarAvro;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class CarConsumer {

    private final CarConsumerUseCase carConsumerUseCase;
    private final CarDTOMapper carDTOMapper;

    @KafkaListener(topics = "${topic.cars.name}")
    public void consumer(ConsumerRecord<String, CarAvro> record, Acknowledgment ack) {
        var carAvroMessage = record.value();

        log.info("Message received:" + carAvroMessage.toString());

        var carDTO = carDTOMapper.toDTO(carAvroMessage);

        carConsumerUseCase.execute(carDTO);

        ack.acknowledge();
    }
}
