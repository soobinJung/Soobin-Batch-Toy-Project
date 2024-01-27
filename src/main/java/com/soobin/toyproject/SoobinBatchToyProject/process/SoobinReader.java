package com.soobin.toyproject.SoobinBatchToyProject.process;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@RequiredArgsConstructor
public class SoobinReader {

    private final DataSource dataSource;

    public ItemReader<SoobinDto> reader() {
        JdbcCursorItemReader<SoobinDto> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(this.dataSource);
        reader.setSql("SELECT id, name FROM SOOBIN");
        reader.setRowMapper(new BeanPropertyRowMapper<>(SoobinDto.class));
        return reader;
    }
}
