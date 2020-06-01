package com.syxfjr.springbatch.processor;

import com.syxfjr.springbatch.entity.Person;
import com.syxfjr.springbatch.service.PersonService;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonProcessor implements ItemProcessor<Person,Person> {

    @Autowired
    private PersonService personService;


    @Override
    public Person process(Person item){
        System.out.println("这里就可以自定义处理了,"+item.getIdCard());
        Person person = personService.queryByIDCard(item.getIdCard());
        if(person != null){
            System.out.println("已处理，无需重复处理");
            return null;
        }
        return item;
    }
}
