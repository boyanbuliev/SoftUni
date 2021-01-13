package com.example.demo.controllers;

import com.example.demo.models.dtos.CustomerSeedRootDto;
import com.example.demo.models.dtos.SupplierSeedRootDto;
import com.example.demo.services.SupplierService;
import com.example.demo.utils.XmlParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.example.demo.constants.GlobalConstants.CUSTOMERS_FILE_PATH;
import static com.example.demo.constants.GlobalConstants.SUPPLIERS_FILE_PATH;

@Component
public class AppController implements CommandLineRunner {
    private final XmlParser xmlParser;
    private final SupplierService supplierService;

    public AppController(XmlParser xmlParser, SupplierService supplierService) {
        this.xmlParser = xmlParser;
        this.supplierService = supplierService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedSuppliers(xmlParser.unmarshalFromFile(SUPPLIERS_FILE_PATH, SupplierSeedRootDto.class));
        this.seedCustomers(xmlParser.unmarshalFromFile(CUSTOMERS_FILE_PATH, CustomerSeedRootDto.class));
    }

    private void seedCustomers(CustomerSeedRootDto customers) {
    }

    private void seedSuppliers(SupplierSeedRootDto suppliers) {
        this.supplierService.seedSuppliers(suppliers);
    }
}
