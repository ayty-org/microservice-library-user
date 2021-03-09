package com.phoebus.library.librarymicroserviceuser.userlibrary.service;

import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibrary;

@FunctionalInterface
public interface GetSpecificIdUserLibraryService {
    UserLibrary findBySpecificID(String specificID);
}
