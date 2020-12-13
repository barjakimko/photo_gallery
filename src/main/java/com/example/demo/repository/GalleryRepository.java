package com.example.demo.repository;

import com.example.demo.entity.Gallery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GalleryRepository extends CrudRepository<Gallery, Long> {
    Optional<Gallery> findById(Long id);
}
