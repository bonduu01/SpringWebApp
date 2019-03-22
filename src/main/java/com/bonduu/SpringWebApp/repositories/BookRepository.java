package com.bonduu.SpringWebApp.repositories;

import com.bonduu.SpringWebApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
