package com.foody.order.service;

import com.foody.order.entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.gridfs.GridFsObject;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceGenerator {

    @Autowired
    MongoOperations mongoOperations;

    public  int generateNewOrderId()
    {
        Sequence counter = mongoOperations.findAndModify(query(where("_id").is("sequence")),
                new Update().inc("sequence",1),
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                Sequence.class);
        return counter.getSequence();
    }
}