package dev.angelcruzl.realestate.service;

import dev.angelcruzl.realestate.model.Estate;

import java.util.List;

public interface EstateService {
  Estate createEstate(Estate estate);

  void deleteEstate(Long estateId);

  List<Estate> getAllEstates();
}
