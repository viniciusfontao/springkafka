package br.com.springkafka.adapter.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CarDTO {

    private String id;
    private String name;
    private String brand;
}
