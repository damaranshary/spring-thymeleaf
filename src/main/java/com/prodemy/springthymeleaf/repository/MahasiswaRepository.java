package com.prodemy.springthymeleaf.repository;

import com.prodemy.springthymeleaf.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Integer> {

}
