package com.prodemy.springthymeleaf.service;

import com.prodemy.springthymeleaf.model.Mahasiswa;

import java.util.List;
import java.util.Optional;

// the purpose of creating this service interface is so that in actual services (serviceImplementation)
// we don't need to implement all the method in JpaRepository interface
public interface MahasiswaService {

    // all methods here is the only methods that
    // we will use from JpaRepository interface

    // this is to get all data from table
    List<Mahasiswa> findAll();

    // this is to get data by using their respective id (primary key)
    Optional<Mahasiswa> findById(Integer nim);

    // this is to search mahasiswa using query/string
    List<Mahasiswa> searchMahasiswaByNameContainingIgnoreCase(String name);

//    List<Mahasiswa> searchMahasiswaByNimContains(Integer nim);

    // this is to create/update a mahasiswa data
    Mahasiswa saveMahasiswa(Mahasiswa mahasiswa);

    // this is to delete data by Id
    void deleteMahasiswaById(Integer id);
}
