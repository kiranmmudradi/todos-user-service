package com.todos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USER_TBL")
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String isActive;
    private Timestamp lastAccessed;
    private Timestamp createdAt;
}
