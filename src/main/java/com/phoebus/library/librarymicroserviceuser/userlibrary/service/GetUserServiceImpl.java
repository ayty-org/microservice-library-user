package com.phoebus.library.librarymicroserviceuser.userlibrary.service;

import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibraryDTO;
import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibraryRepository;
import com.phoebus.library.librarymicroserviceuser.userlibrary.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetUserServiceImpl implements GetUserService {
    private final UserLibraryRepository repository;

    @Override
    public UserLibraryDTO getUserLibrary(Long id) {
        return UserLibraryDTO.from(repository.findById(id).orElseThrow(UserNotFoundException::new));
    }
}