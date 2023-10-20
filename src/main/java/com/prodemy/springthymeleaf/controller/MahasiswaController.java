package com.prodemy.springthymeleaf.controller;

import com.prodemy.springthymeleaf.repository.MahasiswaRepository;
import com.prodemy.springthymeleaf.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;

@Controller
@RequestMapping(path="/")
public class MahasiswaController {
    @Autowired
    private MahasiswaService mahasiswaService;

    @GetMapping(path="/mahasiswa")
    public String getAllMahasiswa(Model model) {
        model.addAttribute("dataMahasiswa", mahasiswaService.findAll());

        return "index";
    }
}
