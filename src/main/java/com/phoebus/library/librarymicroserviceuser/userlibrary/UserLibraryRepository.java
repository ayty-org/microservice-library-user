package com.phoebus.library.librarymicroserviceuser.userlibrary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserLibraryRepository extends JpaRepository<UserLibrary, Long> {
    Optional<UserLibrary> findBySpecificID(String specificID);
}