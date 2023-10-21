package com.prodemy.springthymeleaf.controller;

import com.prodemy.springthymeleaf.model.Mahasiswa;
import com.prodemy.springthymeleaf.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MahasiswaController {
    @Autowired
    private MahasiswaService mahasiswaService;

    // this is a method to make the mahasiswa the starter page
    @RequestMapping(path = "/")
    public String redirectToMahasiswa() {
        return "redirect:/mahasiswa";
    }

    // This is a method to get all mahasiswa in the table
    @GetMapping(path = "/mahasiswa")
    public String getAllMahasiswa(Model model) {
        // we add all mahasiswa data to "dataMahasiswa" attribute
        // the purpose of model.addAttribute is so that we can call it later in the HTML pages
        model.addAttribute("dataMahasiswa", mahasiswaService.findAll());

        return "mahasiswaPage";
    }

    // This is a method to view of the add mahasiswa Form
    @GetMapping(path = "/mahasiswa/add")
    public String addMahasiswaForm(Model model) {
        Mahasiswa mahasiswa = new Mahasiswa();
        // this attribute create a new mahasiswa,
        // so the form at the html will contain only null (empty) for every HTMLinput
        model.addAttribute("mahasiswa", mahasiswa);

        // we call the form with empty data
        return "addMahasiswaPage";
    }

    // This is a method to save the data (can be either update nor create/add)
    @PostMapping(path = "/mahasiswa/add/result")
    public String addMahasiswa(@ModelAttribute("mahasiswa") Mahasiswa mahasiswa, Model model) {
        // we create an attribute mahasiswa to get back the data that sent to the database
        // just for confirmation
        if (mahasiswaService.findById(mahasiswa.getNim()).isPresent()) {
            model.addAttribute("saveResult", false);
        } else {
            model.addAttribute("saveResult", true);
            model.addAttribute("mahasiswa", mahasiswaService.saveMahasiswa(mahasiswa));
        }

        // we show the data that we submit/sent
        return "addResultPage";
    }


    // This is a method to update the mahasiswa by id using PathVariable
    @GetMapping("/mahasiswa/update/{id}")
    public String updateMahasiswaForm(@PathVariable(value = "id") int id, Model model) {
        // this data type is Optional or Mahasiswa because the findById method by jpaRepository is too
        // returning an Optional<T> data type
        Optional<Mahasiswa> mahasiswa = mahasiswaService.findById(id);

        model.addAttribute("mahasiswa", mahasiswa);

        return "updateMahasiswaPage";
    }

    @PostMapping(path = "/mahasiswa/update")
    public String updateMahasiswa(@ModelAttribute("mahasiswa") Mahasiswa mahasiswa, Model model) {
        // we create an attribute mahasiswa to get back the data that sent to the database
        // just for confirmation

        model.addAttribute("mahasiswa", mahasiswaService.saveMahasiswa(mahasiswa));

        // we show the data that we submit/sent
        return "updateResultPage";
    }

    // This is a method to delete the mahasiswa by id using PathVariable
    @GetMapping(path = "/mahasiswa/delete/{id}")
    public String deleteMahasiswa(@PathVariable(value = "id") Integer id) {
        // since deleteById method by jpaRepository doesn't return any value
        // we only need to call the method itself
        this.mahasiswaService.deleteMahasiswaById(id);

        // we will redirect the page after a user delete a data
        return "redirect:/mahasiswa";
    }

    // This is a method to search Mahasiswa by Name
    @GetMapping(path = "/mahasiswa/search")
    public String searchByNameMahasiswa(@RequestParam String query, Model model) {
        // we create a variable named dataMahasiswa to contains everything we found from the query
        List<Mahasiswa> dataMahasiswa;

        dataMahasiswa = mahasiswaService.searchMahasiswaByNameContainingIgnoreCase(query);

        // we add dataMahasiswa data as "dataMahasiswa"
        model.addAttribute("dataMahasiswa", dataMahasiswa);

        return "mahasiswaPage";
    }
}
