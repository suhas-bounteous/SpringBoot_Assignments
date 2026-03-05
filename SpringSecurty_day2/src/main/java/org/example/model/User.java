package org.example.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
@Table("users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private Long id;

    private String username;

    private String password;

    private String role;
}
