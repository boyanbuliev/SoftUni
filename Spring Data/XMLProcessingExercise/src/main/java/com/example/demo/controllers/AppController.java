package com.example.demo.controllers;

import com.example.demo.models.dtos.CarSeedRootDto;
import com.example.demo.models.dtos.CustomerSeedRootDto;
import com.example.demo.models.dtos.PartSeedRootDto;
import com.example.demo.models.dtos.SupplierSeedRootDto;
import com.example.demo.services.*;
import com.example.demo.utils.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import static com.example.demo.constants.GlobalConstants.*;

@Component
public class AppController implements CommandLineRunner {
    private final XmlParser xmlParser;
    private final SupplierService supplierService;
    private final PartService partService;
    private final CustomerService customerService;
    private final CarService carService;
    private final SaleService saleService;

    @Autowired
    public AppController(XmlParser xmlParser, SupplierService supplierService, PartService partService, CustomerService customerService, CarService carService, SaleService saleService) {
        this.xmlParser = xmlParser;
        this.supplierService = supplierService;
        this.partService = partService;
        this.customerService = customerService;
        this.carService = carService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws JAXBException, FileNotFoundException {
        this.seedSuppliers();
        this.seedParts();
        this.seedCars();
        this.seedCustomers();
        this.seedSales();
        this.carService.getPrice();
    }

    private void seedSales() {
        saleService.seedSales();
    }

    private void seedCars() throws JAXBException, FileNotFoundException {
        carService.seedCars(xmlParser
                .unmarshalFromFile(CARS_FILE_PATH, CarSeedRootDto.class).getCars());
    }

    private void seedParts() throws JAXBException, FileNotFoundException {
        this.partService.seedParts(xmlParser
                .unmarshalFromFile(PARTS_FILE_PATH, PartSeedRootDto.class).getParts());
    }

    private void seedCustomers() throws JAXBException, FileNotFoundException {
        this.customerService.seedCustomers(xmlParser
                .unmarshalFromFile(CUSTOMERS_FILE_PATH, CustomerSeedRootDto.class).getCustomers());

    }

    private void seedSuppliers() throws JAXBException, FileNotFoundException {
        this.supplierService.seedSuppliers(xmlParser
                .unmarshalFromFile(SUPPLIERS_FILE_PATH, SupplierSeedRootDto.class).getSuppliers());
    }
}
