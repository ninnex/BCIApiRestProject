package com.bci.BCIProject.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Data
@Builder
public class User {
    @Id
    private UUID uuid = UUID.randomUUID();
    private String name;
    @Column(unique = true)
    @Email(regexp = ".+@.+\\..+", message = "Provea un email válido")
    private String email;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password inseguro")
    private String password;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Phone> phones;
    private OffsetDateTime createdTime;
    private Boolean isActive = true;

}
