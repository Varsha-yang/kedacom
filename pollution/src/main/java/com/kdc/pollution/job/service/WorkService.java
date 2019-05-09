package com.kdc.pollution.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class WorkService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void execute(){
        String sql = "select * from temp_garage_renovation";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);

     List<Object> list =   mapList.stream().map(map->map.get("plt")).collect(Collectors.toList());
     //list.forEach(obj-> System.out.println(obj));
     //list.stream().distinct().forEach(obj-> System.out.println(obj));
     list.stream().filter(obj->!obj.equals("合计")).distinct().forEach(obj-> System.out.println(obj));

    }
}
