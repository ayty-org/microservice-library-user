package com.phoebus.library.librarymicroserviceuser.userlibrary.service;

import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibrary;
import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibraryRepository;
import com.phoebus.library.librarymicroserviceuser.userlibrary.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetSpecificIdUserLibraryServiceImpl implements GetSpecificIdUserLibraryService{
    private final UserLibraryRepository repository;

    @Override
    public UserLibrary findBySpecificID(String specificID) {
        return repository.findBySpecificID(specificID).orElseThrow(UserNotFoundException::new);
    }
}
