package com.bonduu.SpringWebApp.repositories;

import com.bonduu.SpringWebApp.model.AuthorProfile;
import org.springframework.data.repository.CrudRepository;

public interface AuthorProfileRepository extends CrudRepository<AuthorProfile, Long> {
}
