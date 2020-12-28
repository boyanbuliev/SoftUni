package com.example.demo.services;

import com.example.demo.domain.entities.Label;
import com.example.demo.repositories.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService {
    private final LabelRepository labelRepository;

    @Autowired
    public LabelServiceImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    @Override
    public Label findById(long id) {
        return this.labelRepository.getById(id);
    }
}
