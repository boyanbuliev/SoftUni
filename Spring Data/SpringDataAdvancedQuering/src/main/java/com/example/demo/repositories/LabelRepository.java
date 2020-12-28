package com.example.demo.repositories;

import com.example.demo.domain.entities.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {
    List<Label> findAllBySubtitle(String subtitle);

    Label getById(Long id);
}
