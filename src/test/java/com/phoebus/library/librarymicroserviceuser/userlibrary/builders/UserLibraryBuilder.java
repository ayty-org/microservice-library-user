package com.phoebus.library.librarymicroserviceuser.userlibrary.builders;

import com.phoebus.library.librarymicroserviceuser.userlibrary.UserLibrary;

public class UserLibraryBuilder {


    public static UserLibrary.Builder createUserLibrary() {
        return UserLibrary.builder()
                .id(1L)
                .name("Test")
                .age(22)
                .phone("0000-0000")
                .email("teste@teste.com")
                .gender("M");
    }
}
