package dev.angelcruzl.realestate.controller;

import dev.angelcruzl.realestate.model.Estate;
import dev.angelcruzl.realestate.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/estates")
public class EstateController {
  @Autowired
  private EstateService estateService;

  @GetMapping
  public ResponseEntity<?> getAllEstates() {
    return new ResponseEntity<>(estateService.getAllEstates(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<?> createEstate(@RequestBody Estate estate) {
    return new ResponseEntity<>(estateService.createEstate(estate), HttpStatus.CREATED);
  }

  @DeleteMapping("/{estateId}")
  public ResponseEntity<?> deleteEstate(@PathVariable Long estateId) {
    estateService.deleteEstate(estateId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
