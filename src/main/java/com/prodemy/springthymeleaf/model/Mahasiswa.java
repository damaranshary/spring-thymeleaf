package com.prodemy.springthymeleaf.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "data_mahasiswa")
public class Mahasiswa {

    @Id
    @Column(name = "nim")
    private Integer nim;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public Mahasiswa(Integer nim, String name, String address, Date birthday) {
        this.nim = nim;
        this.name = name;
        this.address = address;
        this.birthday = birthday;
    }

    public Mahasiswa() {
    }

    public Integer getNim() {
        return nim;
    }

    public void setNim(Integer nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("nim=%d // name=%s // address=%s // bday=%s", nim, name, address, birthday.toString());
    }
}
