package com.soobin.toyproject.SoobinBatchToyProject.process;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

@Component
@RequiredArgsConstructor
public class SoobinJob {

    private final SoobinStep soobinStep;

    @Bean("soobinFirstJob")
    public Job job(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        System.out.println("Job 을 시작합니다.");
        return new JobBuilder("soobinFirstJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(soobinStep.step(jobRepository, transactionManager))
                .build();
    }
}
