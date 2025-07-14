package org.poopoo.book_management.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDto {
    private Integer id;

    @NotBlank(message = "name is not blank")
    private String name;
}
