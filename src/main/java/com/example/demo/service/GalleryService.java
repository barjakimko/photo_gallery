package com.example.demo.service;

import com.example.demo.entity.Gallery;

public interface GalleryService {

    Gallery findById(Long id);

    void saveGallery(Gallery gallery);
}
