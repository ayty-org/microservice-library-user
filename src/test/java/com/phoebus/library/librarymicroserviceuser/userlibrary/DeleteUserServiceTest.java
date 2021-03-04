package com.phoebus.library.librarymicroserviceuser.userlibrary;

import com.phoebus.library.librarymicroserviceuser.userlibrary.exceptions.UserNotFoundException;
import com.phoebus.library.librarymicroserviceuser.userlibrary.service.DeleteUserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@Tag("Service")
@DisplayName("Test to know if service responsible to delete an User Library")
public class DeleteUserServiceTest {

    @Mock
    private UserLibraryRepository repository;

    private DeleteUserServiceImpl deleteUserLibrary;

    @BeforeEach
    void setUp() {
        this.deleteUserLibrary = new DeleteUserServiceImpl(repository);
    }

    @Test
    @DisplayName("Should delete an User Library")
    void shouldDeleteUser() {

        when(repository.existsById(anyLong())).thenReturn(true);

        deleteUserLibrary.delete(1L);
        verify(repository).deleteById(anyLong());
    }

    @Test
    @DisplayName("Should throw User Library Not Found Exception ")
    void shouldNotFoundExeception() {
        when(repository.existsById(anyLong())).thenReturn(false);

        Assertions.assertThrows(UserNotFoundException.class, () -> deleteUserLibrary.delete(1L));

        verify(repository, times(0)).deleteById(anyLong());
    }
}