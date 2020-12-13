package com.example.demo.service;

import com.example.demo.entity.Gallery;
import com.example.demo.exception.IdNotFoundException;
import com.example.demo.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GalleryServiceImpl implements GalleryService {

    GalleryRepository galleryRepository;

    @Autowired
    public GalleryServiceImpl(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    @Override
    public Gallery findById(Long id) {
        return galleryRepository.findById(id).orElseThrow(
                () -> new IdNotFoundException(id, Gallery.class.getSimpleName()));
    }

    @Override
    public void saveGallery(Gallery gallery) {
        galleryRepository.save(gallery);
    }
}
