package com.phoebus.library.librarymicroserviceuser.userlibrary.service;

import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibraryDTO;

@FunctionalInterface
public interface SaveUserService {
    void save(UserLibraryDTO userLibraryDTO);
}
