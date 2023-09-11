package com.example.demo5;
import jakarta.persistence.*;
//import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

//import javax.persistence.*;


@Getter
@Setter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "todo")
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "title")
    String title;
    String detail;

}
