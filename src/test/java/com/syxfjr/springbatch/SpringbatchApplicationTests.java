package com.syxfjr.springbatch;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbatchApplication.class)
class SpringbatchApplicationTests {

    @Autowired
    private Job personJob;
    @Autowired
    private JobLauncher jobLauncher;

    @Test
    void contextLoads() throws Exception {
        //添加启动参数是为了重复跑批，如果每次参数一样则不会重复处理。
        JobParameters jobParameters = new JobParametersBuilder()
                .addDate("date", new Date())
                .toJobParameters();
        JobExecution run = jobLauncher.run(personJob, jobParameters);
    }

}
