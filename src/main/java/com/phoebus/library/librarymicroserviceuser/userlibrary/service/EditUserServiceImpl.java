package com.phoebus.library.librarymicroserviceuser.userlibrary.service;

import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibrary;
import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibraryDTO;
import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibraryRepository;
import com.phoebus.library.librarymicroserviceuser.userlibrary.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EditUserServiceImpl implements EditUserService {
    private final UserLibraryRepository repository;

    @Override
    public void editUserLibrary(Long id, UserLibraryDTO userLibraryDTO) {
        UserLibrary userLibrary = repository.findById(id).orElseThrow(UserNotFoundException::new);

        userLibrary.setAge(userLibraryDTO.getAge());
        userLibrary.setEmail(userLibraryDTO.getEmail());
        userLibrary.setName(userLibraryDTO.getName());
        userLibrary.setGender(userLibraryDTO.getGender());
        userLibrary.setPhone(userLibraryDTO.getPhone());

        repository.save(userLibrary);
    }
}
