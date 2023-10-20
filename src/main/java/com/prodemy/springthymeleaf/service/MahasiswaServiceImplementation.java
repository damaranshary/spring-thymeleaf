package com.prodemy.springthymeleaf.service;

import com.prodemy.springthymeleaf.model.Mahasiswa;
import com.prodemy.springthymeleaf.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MahasiswaServiceImplementation implements MahasiswaService{

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @Override
    public List<Mahasiswa> findAll() {
        return mahasiswaRepository.findAll();
    }

    public Optional<Mahasiswa> findById(Integer nim ) {
        return mahasiswaRepository.findById(nim);
    }




}
