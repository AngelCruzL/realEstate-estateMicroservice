package dev.angelcruzl.realestate.service;

import dev.angelcruzl.realestate.model.Estate;
import dev.angelcruzl.realestate.repository.EstateRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EstateServiceImpl implements EstateService {
  private final EstateRepository estateRepository;

  public EstateServiceImpl(EstateRepository estateRepository) {
    this.estateRepository = estateRepository;
  }

  @Override
  public Estate createEstate(Estate estate) {
    estate.setCreatedAt(LocalDateTime.now());
    return estateRepository.save(estate);
  }

  @Override
  public void deleteEstate(Long estateId) {
    estateRepository.deleteById(estateId);
  }

  @Override
  public List<Estate> getAllEstates() {
    return estateRepository.findAll();
  }
}
