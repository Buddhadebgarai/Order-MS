package com.foody.order.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence")
@Data
public class Sequence {

    @Id
    private  String id;

    private  int sequence;
}