package com.waddwaw.demo;

import org.springframework.stereotype.Repository;

/**
 * Created by liqiang on 16/9/15.
 *   id int(11) not null primary key auto_increment,
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
 *
 */
@Repository
public class StudentsEntity {

    private Integer id;
    private String name;
    private String nameTel;
    private String parentsName;
    private String parentsNameTel;
    private String sex;
    private String wechat;
    private String qq;
    private String address;
    private String professional;
    private Long nameCreateTime;
    private String nameIdentityCard;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameTel() {
        return nameTel;
    }

    public void setNameTel(String nameTel) {
        this.nameTel = nameTel;
    }

    public String getParentsName() {
        return parentsName;
    }

    public void setParentsName(String parentsName) {
        this.parentsName = parentsName;
    }

    public String getParentsNameTel() {
        return parentsNameTel;
    }

    public void setParentsNameTel(String parentsNameTel) {
        this.parentsNameTel = parentsNameTel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public Long getNameCreateTime() {
        return nameCreateTime;
    }

    public void setNameCreateTime(Long nameCreateTime) {
        this.nameCreateTime = nameCreateTime;
    }

    public String getNameIdentityCard() {
        return nameIdentityCard;
    }

    public void setNameIdentityCard(String nameIdentityCard) {
        this.nameIdentityCard = nameIdentityCard;
    }
}
