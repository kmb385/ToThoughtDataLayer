package org.tothought.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tothought.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

}
