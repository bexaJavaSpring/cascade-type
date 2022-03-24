package uz.pdp.cascadetype.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    @OrderBy(value = "name desc")
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    List<District> districts;
}
