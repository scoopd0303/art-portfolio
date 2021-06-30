package com.trashdoodles.artportfolio.data;

import com.trashdoodles.artportfolio.models.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image, Integer> {
}
