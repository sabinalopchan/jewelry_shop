package com.example.jewelry_store.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @SequenceGenerator(name="role_seq_gen", sequenceName = "role_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "role_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(nullable = false,name = "name")
    private String name;
//    @ManyToMany(mappedBy = "roles")
//    private List<User> users;
}


//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//
//    @Column(nullable = false, unique = true)
//    @NotEmpty
//    private String name;
//
//    @ManyToMany(mappedBy = "roles")
//    private List<User> users;
//
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
//}
