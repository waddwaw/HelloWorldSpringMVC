package com.waddwaw.demo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by liqiang on 16/9/15.
 * id int(11) not null primary key auto_increment,
 name varchar(50) not null,
 nameTel varchar(50) not null,
 parentsName varchar(50) not null,
 parentsNameTel varchar(50) not null,
 sex varchar(10),
 wechat varchar(50),
 qq varchar(20),
 address varchar(100),
 professional varchar(100),
 nameCreateTime BIGINT(13),
 nameIdentityCard varchar(100)
 */
@MapperScan
public interface StudentsMapper {

    @Select("SELECT * FROM tab_21Students WHERE name LIKE '%${name}%'")
    List<StudentsEntity> findByName(@Param("name") String name);

}
