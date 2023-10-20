package com.prodemy.springthymeleaf.repository;

import com.prodemy.springthymeleaf.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Integer> {
    Optional<Mahasiswa> searchMahasiswaByName(String name);

    Optional<Mahasiswa> searchMahasiswaByNim(Integer nim);
}
