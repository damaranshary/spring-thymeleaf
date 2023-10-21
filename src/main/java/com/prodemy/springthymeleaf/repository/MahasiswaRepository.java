package com.prodemy.springthymeleaf.repository;

import com.prodemy.springthymeleaf.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Integer> {
    // in JpaRepository, there is so many SQL query that you can do only with their method
    // this is created by spring that later be converted to be a SQL query
    // this searchMahasiswaByNameContainingIgnoreCase is one of them
    // the equivalent MySQL query is probably goes like this -> "SELECT * FROM mahasiswa WHERE name LIKE %name%"
    List<Mahasiswa> searchMahasiswaByNameContainingIgnoreCase(String name);
    // so with spring you don't actually need to write the query yourself, you just need to write
    // what kind of logic you want to do

    // altho you can still do it by native query like below here
//    @Query(value="SELECT * FROM data_mahasiswa WHERE nim LIKE '%:q%' ", nativeQuery = true)
//    List<Mahasiswa> searchMahasiswaByNimContains(@Param("q") Integer nim);
}
