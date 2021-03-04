package com.phoebus.library.librarymicroserviceuser.userlibrary.service;

import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibraryDTO;

@FunctionalInterface
public interface EditUserService {
    void editUserLibrary(Long id, UserLibraryDTO userLibraryDTO);
}

