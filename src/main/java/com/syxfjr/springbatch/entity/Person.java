package com.syxfjr.springbatch.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Person)实体类
 *
 * @author makejava
 * @since 2020-05-28 15:23:17
 */
public class Person implements Serializable {
    private static final long serialVersionUID = -65474598397502703L;
    
    private Integer id;
    
    private String firstName;
    
    private String lastName;
    
    private Integer age;
    
    private Date recordTime;
    
    private String idCard;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

}