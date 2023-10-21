package com.prodemy.springthymeleaf.service;

import com.prodemy.springthymeleaf.model.Mahasiswa;
import com.prodemy.springthymeleaf.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// this basically a service Implementation using the JpaRepository
// using the mahasiswaService interface
@Service
public class MahasiswaServiceImplementation implements MahasiswaService {

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @Override
    public List<Mahasiswa> findAll() {
        return mahasiswaRepository.findAll();
    }

    @Override
    public Optional<Mahasiswa> findById(Integer nim) {
        return mahasiswaRepository.findById(nim);
    }

    @Override
    public List<Mahasiswa> searchMahasiswaByNameContainingIgnoreCase(String name) {
        return mahasiswaRepository.searchMahasiswaByNameContainingIgnoreCase(name);
    }

//    @Override
//    public List<Mahasiswa> searchMahasiswaByNimContains(Integer nim) {
//        return mahasiswaRepository.searchMahasiswaByNimContains(nim);
//    }

    @Override
    public Mahasiswa saveMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswaRepository.save(mahasiswa);

        return mahasiswa;
    }

    @Override
    public void deleteMahasiswaById(Integer id) {
        this.mahasiswaRepository.deleteById(id);
    }
}
