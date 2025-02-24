package com.project.uber.controller;

import com.project.uber.model.Company;
import com.project.uber.service.implementation.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;

    @PostMapping("/register")
    public ResponseEntity<Company> registerCompany(@RequestBody Company company) {
        Company savedCompany = companyService.registerCompany(company);
        return ResponseEntity.ok(savedCompany);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Optional<Company> company = companyService.getCompanyById(id);
        return company.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }
}

