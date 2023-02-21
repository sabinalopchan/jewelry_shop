package com.example.jewelry_store.pojo;

import com.example.jewelry_store.entity.Role;
import com.example.jewelry_store.entity.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {

    private Integer id;

    @NotEmpty(message = "Username cannot be empty")
    private String firstName;

    @NotEmpty(message = "Username cannot be empty")
    private String lastName;


    @NotEmpty(message = "Email cannot be empty")
    private String email;

//    @NotEmpty(message = "(Password cannot be empty")
    private String password;

    private List<Role> roles;

    public UserPojo(User user){
        this.id= user.getId();
        this.firstName=user.getFirstName();
        this.lastName=user.getLastName();
        this.email= user.getEmail();
        this.password= user.getPassword();
        this.roles=user.getRoles();
    }


}
