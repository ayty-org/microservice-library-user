package com.phoebus.library.librarymicroserviceuser.userlibrary.service;

import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibraryDTO;

import java.util.List;

@FunctionalInterface
public interface ListUserService {
    public List<UserLibraryDTO> listUserLibrary();
}