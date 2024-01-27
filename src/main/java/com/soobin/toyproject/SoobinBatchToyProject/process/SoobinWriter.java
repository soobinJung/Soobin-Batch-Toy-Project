package com.soobin.toyproject.SoobinBatchToyProject.process;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SoobinWriter implements ItemWriter<SoobinDto> {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void write(Chunk<? extends SoobinDto> chunk) {
        for(SoobinDto soobinDto : chunk.getItems()) {
            jdbcTemplate.update("INSERT INTO SOOBIN_BACKUP (id, name) VALUES(?, ?)", soobinDto.getId(), soobinDto.getName());
        }
    }
}