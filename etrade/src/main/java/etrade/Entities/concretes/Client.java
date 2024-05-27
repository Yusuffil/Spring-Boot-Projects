package etrade.Entities.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullname;

    private String identityNumber;

    @OneToMany(mappedBy = "client")
    private List<Order> orders;


}
