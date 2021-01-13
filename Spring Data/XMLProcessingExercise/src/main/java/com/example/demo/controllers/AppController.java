package com.example.demo.controllers;

import com.example.demo.models.dtos.SupplierSeedRootDto;
import com.example.demo.services.SupplierService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static com.example.demo.constants.GlobalConstants.SUPPLIERS_FILE_PATH;

@Component
public class AppController implements CommandLineRunner {
    private final SupplierService supplierService;

    public AppController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Override
    public void run(String... args) throws Exception {
        JAXBContext ctx = JAXBContext.newInstance(SupplierSeedRootDto.class);
        Unmarshaller unmarshaller = ctx.createUnmarshaller();
        SupplierSeedRootDto unmarshal = (SupplierSeedRootDto) unmarshaller.
                unmarshal(new File(SUPPLIERS_FILE_PATH));
        this.seedSuppliers(unmarshal);
    }

    private void seedSuppliers(SupplierSeedRootDto suppliers) {
        this.supplierService.seedSuppliers(suppliers);
    }
}
