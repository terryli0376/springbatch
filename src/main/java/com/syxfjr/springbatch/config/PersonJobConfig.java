package com.syxfjr.springbatch.config;

import com.syxfjr.springbatch.entity.Person;
import com.syxfjr.springbatch.processor.PersonProcessor;
import com.syxfjr.springbatch.reader.mapper.PersonMapper;
import com.syxfjr.springbatch.writer.PersonWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;

@Configuration
@EnableBatchProcessing
public class PersonJobConfig {

    @Resource
    public JobBuilderFactory jobBuilderFactory;

    @Resource
    public StepBuilderFactory stepBuilderFactory;

    @Resource
    public PersonProcessor personProcessor;

    @Resource
    public PersonWriter personWriter;

    @Bean
    public Job personJob(){
        return jobBuilderFactory.get("personJob").start(personStep()).build();
    }

    @Bean
    public Step personStep(){
        return stepBuilderFactory.get("personStep").<Person,Person>chunk(2).reader(reader()).processor(personProcessor)
                .writer(personWriter).build();
    }

    @Bean
    public FlatFileItemReader<Person> reader(){
        return new FlatFileItemReaderBuilder<Person>().name("personReader").resource(new ClassPathResource("person.csv"))
                .fieldSetMapper(new PersonMapper()).lineTokenizer(new DelimitedLineTokenizer(",")).build();
    }

}
