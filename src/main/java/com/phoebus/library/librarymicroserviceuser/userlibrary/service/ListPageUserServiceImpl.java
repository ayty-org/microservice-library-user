package com.phoebus.library.librarymicroserviceuser.userlibrary.service;

import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibraryDTO;
import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListPageUserServiceImpl implements ListPageUserService{

    private final UserLibraryRepository repository;

    @Override
    public Page<UserLibraryDTO> listUserOnPage(Pageable pageable) {
        return UserLibraryDTO.from(repository.findAll(pageable));
    }
}