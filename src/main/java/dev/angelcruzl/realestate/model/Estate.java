package dev.angelcruzl.realestate.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "estate")
public class Estate {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", length = 150, nullable = false)
  private String name;

  @Column(name = "address", length = 500, nullable = false)
  private String address;

  @Column(name = "picture", length = 1200, nullable = true)
  private String picture;

  @Column(name = "price", nullable = false)
  private Double price;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;
}
