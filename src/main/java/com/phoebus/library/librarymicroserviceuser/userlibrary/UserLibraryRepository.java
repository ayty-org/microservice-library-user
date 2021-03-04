package com.phoebus.library.librarymicroserviceuser.userlibrary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLibraryRepository extends JpaRepository<UserLibrary, Long> {
}