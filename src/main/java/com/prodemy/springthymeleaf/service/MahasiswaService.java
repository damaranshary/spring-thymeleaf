package com.prodemy.springthymeleaf.service;

import com.prodemy.springthymeleaf.model.Mahasiswa;

import java.util.List;
import java.util.Optional;

public interface MahasiswaService {
    List<Mahasiswa> findAll();

    Optional<Mahasiswa> findById(Integer nim);

    Optional<Mahasiswa> searchMahasiswaByName(String name);

    Optional<Mahasiswa> searchMahasiswaByNim(Integer nim);

    void saveMahasiswa(Mahasiswa mahasiswa);

    void deleteMahasiswaById(Integer id);

}
