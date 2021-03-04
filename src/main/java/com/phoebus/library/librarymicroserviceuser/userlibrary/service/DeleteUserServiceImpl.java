package com.phoebus.library.librarymicroserviceuser.userlibrary.service;

import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibraryRepository;
import com.phoebus.library.librarymicroserviceuser.userlibrary.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteUserServiceImpl implements DeleteUserService{

    private final UserLibraryRepository repository;

    @Override
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new UserNotFoundException();
        }
        repository.deleteById(id);
    }
}