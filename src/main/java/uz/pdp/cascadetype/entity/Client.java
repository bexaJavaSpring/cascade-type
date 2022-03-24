package uz.pdp.cascadetype.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"name","age"})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Date birthDate; //1997-08-04

    @Transient//frontga
    private int age; //yoshi

    public int getAge() {
        return new Date().getYear() - this.birthDate.getYear();
    }

    //    @OnDelete(action = OnDeleteAction.CASCADE)
//    @ManyToOne
//    private BankAccount bankAccount;

}
