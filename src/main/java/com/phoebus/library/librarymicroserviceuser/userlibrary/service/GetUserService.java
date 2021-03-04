package com.phoebus.library.librarymicroserviceuser.userlibrary.service;

import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibraryDTO;

@FunctionalInterface
public interface GetUserService {
    UserLibraryDTO getUserLibrary(Long id);
}
