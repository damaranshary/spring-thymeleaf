package com.prodemy.springthymeleaf.controller;

import com.prodemy.springthymeleaf.model.Mahasiswa;
import com.prodemy.springthymeleaf.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/")
public class MahasiswaController {
    @Autowired
    private MahasiswaService mahasiswaService;

    @GetMapping(path = "/mahasiswa")
    public String getAllMahasiswa(Model model) {
        model.addAttribute("dataMahasiswa", mahasiswaService.findAll());

        System.out.println(mahasiswaService.findAll().get(1).getBirthday());

        return "index";
    }

    @GetMapping(path = "/mahasiswa/add")
    public String addMahasiswaForm(Model model) {
        Mahasiswa mahasiswa = new Mahasiswa();
        model.addAttribute("mahasiswa", mahasiswa);

        return "addMahasiswaPage";
    }

    @PostMapping(path = "/mahasiswa/save")
    public String saveMahasiswa(@ModelAttribute("mahasiswa") Mahasiswa mahasiswa) {
        mahasiswaService.saveMahasiswa(mahasiswa);

        return "redirect:/mahasiswa";
    }

    @GetMapping("/mahasiswa/update/{id}")
    public String updateMahasiswaForm(@PathVariable(value = "id") int id, Model model) {
        Optional<Mahasiswa> mahasiswa = mahasiswaService.findById(id);

        model.addAttribute("mahasiswa", mahasiswa);

        return "updateMahasiswaPage";
    }

    @GetMapping(path = "/mahasiswa/delete/{id}")
    public String deleteMahasiswa(@PathVariable(value = "id") Integer id) {
        this.mahasiswaService.deleteMahasiswaById(id);

        return "redirect:/mahasiswa";
    }

    @GetMapping(path = "/mahasiswa/search")
    public String searchByNameAndIdMahasiswa(@RequestParam String query, Model model) {

        Optional<Mahasiswa> mahasiswa;

        try {
            int queryInt = Integer.parseInt(query);

            // if it's success, we will search the query via NIM instead of name
            mahasiswa = this.mahasiswaService.searchMahasiswaByNim(queryInt);
        } catch (NumberFormatException e) {
            // and if it's failed, we will search the query via name
            mahasiswa = this.mahasiswaService.searchMahasiswaByName(query);
        }
        model.addAttribute("dataMahasiswa", mahasiswa);

        return "index";
    }
}
