package com.phoebus.library.librarymicroserviceuser.userlibrary;

import  org.junit.jupiter.api.BeforeEach;
import com.phoebus.library.librarymicroserviceuser.userlibrary.exceptions.UserNotFoundException;
import com.phoebus.library.librarymicroserviceuser.userlibrary.service.EditUserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.phoebus.library.librarymicroserviceuser.userlibrary.builders.UserLibraryBuilder.createUserLibrary;
import static com.phoebus.library.librarymicroserviceuser.userlibrary.builders.UserLibraryBuilderDTO.createUserLibraryDTO;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@Tag("service")
@DisplayName("Test to verify if it's Editing an User Library")
public class EditUserServiceTest {

    @Mock
    private UserLibraryRepository repository;

    private EditUserServiceImpl editUserServiceImpl;

    @BeforeEach
    void setUp() {
        this.editUserServiceImpl = new EditUserServiceImpl(repository);
    }

    @Test
    @DisplayName("Should returns an Edited User Library")
    void shouldEditAnUser() {
        UserLibraryDTO userLibraryDTO = createUserLibraryDTO().name("Teste").build();
        UserLibrary userLibrary = createUserLibrary().build();

        Optional<UserLibrary> userLibraryOptional = Optional.of(userLibrary);
        when(repository.findById(anyLong())).thenReturn(userLibraryOptional);

        editUserServiceImpl.editUserLibrary(1L, userLibraryDTO);

        ArgumentCaptor<UserLibrary> captorUserLibrary = ArgumentCaptor.forClass(UserLibrary.class);
        verify(repository, times(1)).save(captorUserLibrary.capture());

        UserLibrary result = captorUserLibrary.getValue();

        assertAll("User",
                () -> assertThat(result.getName(), is("Teste")),
                () -> assertThat(result.getAge(), is(22)),
                () -> assertThat(result.getPhone(), is("0000-0000")),
                () -> assertThat(result.getEmail(), is("teste@teste.com")),
                () -> assertThat(result.getGender(), is("M"))
        );
    }



    @Test
    @DisplayName("Should throws an Exception of Edit an User Library")
    void shouldThrowsExceptionEditAnUser() {
        UserLibraryDTO userLibraryDTO = createUserLibraryDTO().name("Teste").build();
        UserLibrary userLibrary = createUserLibrary().build();

        Optional<UserLibrary> userLibraryOptional = Optional.of(userLibrary);
        when(repository.findById(anyLong())).thenThrow( new UserNotFoundException());

        assertThrows(UserNotFoundException.class, () -> editUserServiceImpl.editUserLibrary(1L, userLibraryDTO));

        verify(repository, times(0)).save(any());





    }
}