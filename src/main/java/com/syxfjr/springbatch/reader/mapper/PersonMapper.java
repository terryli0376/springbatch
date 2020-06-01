package com.syxfjr.springbatch.reader.mapper;

import com.syxfjr.springbatch.entity.Person;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PersonMapper implements FieldSetMapper<Person> {
    @Override
    public Person mapFieldSet(FieldSet fieldSet){
        Person p = new Person();
        p.setFirstName(fieldSet.readString(0));
        p.setLastName(fieldSet.readString(1));
        p.setAge(Integer.valueOf(fieldSet.readString(2)));
        String recordTime = fieldSet.readString(3);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            p.setRecordTime(sf.parse(recordTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        p.setIdCard(fieldSet.readString(4));
        return p;
    }
}
