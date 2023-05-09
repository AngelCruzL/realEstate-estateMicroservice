package dev.angelcruzl.realestate.repository;

import dev.angelcruzl.realestate.model.Estate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstateRepository extends JpaRepository<Estate, Long> {
}
