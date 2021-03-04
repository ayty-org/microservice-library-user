package com.phoebus.library.librarymicroserviceuser.userlibrary;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="tb_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class UserLibrary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USER_ID")
    private Long id;

    private String name;
    private int age;
    private String phone;

    @Column(unique = true)
    private String email;

    private String gender;

    @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID specificID = UUID.randomUUID();

    public static UserLibrary to(UserLibraryDTO userLibraryDTO) {
        return UserLibrary.builder()
                .id(userLibraryDTO.getId())
                .name(userLibraryDTO.getName())
                .age(userLibraryDTO.getAge())
                .phone(userLibraryDTO.getPhone())
                .email(userLibraryDTO.getEmail())
                .gender(userLibraryDTO.getGender())
                .specificID(userLibraryDTO.getSpecificID())
                .build();
    }

    public static List<UserLibrary> to(List<UserLibraryDTO> userLibraryDTOList) {
        List<UserLibrary> userLibraryList = new ArrayList<>();
        for(UserLibraryDTO userLibraryDTO : userLibraryDTOList) {
            userLibraryList.add(UserLibrary.to(userLibraryDTO));
        }
        return userLibraryList;
    }

    public static Page<UserLibrary> to(Page<UserLibraryDTO> pages) {
        return pages.map(UserLibrary::to);
    }
}