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

    @Override
    public Optional<Mahasiswa> findById(Integer nim ) {
        return mahasiswaRepository.findById(nim);
    }

    @Override
    public Optional<Mahasiswa> searchMahasiswaByName(String name) {
        return mahasiswaRepository.searchMahasiswaByName(name);
    }

    @Override
    public Optional<Mahasiswa> searchMahasiswaByNim(Integer nim) {
        return mahasiswaRepository.searchMahasiswaByNim(nim);
    }

    @Override
    public void saveMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswaRepository.save(mahasiswa);
    }

    @Override
    public void deleteMahasiswaById(Integer id) {
        this.mahasiswaRepository.deleteById(id);
    }
}
