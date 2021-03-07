package com.phoebus.library.librarymicroserviceuser.userlibrary.builders;

import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibraryDTO;

import java.util.UUID;

public class UserLibraryBuilderDTO {

    public static UserLibraryDTO.Builder createUserLibraryDTO() {
        return UserLibraryDTO.builder()
                .id(1L)
                .name("Test")
                .age(22)
                .phone("0000-0000")
                .email("teste@teste.com")
                .specificID("d2dbaa68-48c6-451e-b34f-57b5b70fc0ed")
                .gender("M");
    }
}