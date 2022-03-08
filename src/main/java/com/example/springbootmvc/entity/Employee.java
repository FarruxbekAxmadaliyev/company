package com.example.springbootmvc.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String fullname;
private String phone;
@ManyToOne
private Department department;

}
