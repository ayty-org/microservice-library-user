package com.phoebus.library.librarymicroserviceuser.userlibrary.service;

import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibrary;
import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibraryDTO;
import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SaveUserServiceImpl implements SaveUserService {
    private final UserLibraryRepository repository;

    @Override
    public void save(UserLibraryDTO userLibraryDTO) {
        UserLibrary userLibrary = UserLibrary.to(userLibraryDTO);

        repository.save(userLibrary);
    }
}