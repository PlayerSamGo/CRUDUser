package com.sam.user.model;


import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Getter
@Setter
@Entity //Anotation to set entity
@AllArgsConstructor
@Table(name="user") //Anotation to define table
public class User {

    @Id //To relate id table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //To increase one to one
    private Integer id;

    @NotNull(message = "firstName.required")
    @NotBlank(message = "firstName.blank")
    @Size(min = 3, message = "firstName.min")
    @Column(nullable = false, length = 50)
    private String firstName;

    @NotNull(message = "lastName.required")
    @NotBlank(message = "lastName.blank")
    @Size(min = 3, message = "lastName.min")
    @Column(nullable = false, length = 50)
    private String lastName;

    @NotNull(message = "dateOfBirth.required")
    @Past(message = "dateOfBirth.past")
    @Column(nullable = false)
    private Date dateOfBirth;

    @NotNull(message = "status.required")
    @NotBlank(message = "status.blank")
    @Pattern(regexp = "ACTIVE|INACTIVE", message = "status.invalid")
    @Column(nullable = false)
    private String  status;

}
