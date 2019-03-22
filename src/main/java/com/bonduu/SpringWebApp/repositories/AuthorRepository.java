package com.bonduu.SpringWebApp.repositories;

import com.bonduu.SpringWebApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
