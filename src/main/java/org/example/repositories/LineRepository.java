package org.example.repositories;

import org.example.models.Line;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineRepository extends JpaRepository<Line, Integer> {
}
