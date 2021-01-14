package com.example.demo.services;

import com.example.demo.models.dtos.PartSeedDto;
import com.example.demo.models.entities.Part;

import java.util.List;
import java.util.Set;

public interface PartService {
    void seedParts(List<PartSeedDto> parts);

    Set<Part> getRandomParts();
}
