package com.soobin.toyproject.SoobinBatchToyProject.process;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

@Component
@RequiredArgsConstructor
public class SoobinStep {

    private final SoobinReader reader;
    private final SoobinWriter write;

    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager) {

        System.out.println("Step 을 시작합니다.");

        return new StepBuilder("step",jobRepository)
                .<SoobinDto, SoobinDto>chunk(2, transactionManager)
                .reader(reader.reader())
                .writer(write)
                .transactionManager(transactionManager)
                .build();
    }
}