package com.syxfjr.springbatch.writer;

import com.syxfjr.springbatch.entity.Person;
import com.syxfjr.springbatch.service.PersonService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonWriter implements ItemWriter<Person> {

    @Autowired
    private PersonService personService;

    @Override
    public void write(List<? extends Person> items) throws Exception {
        for(Person p : items){
            personService.insert(p);
        }
    }
}
