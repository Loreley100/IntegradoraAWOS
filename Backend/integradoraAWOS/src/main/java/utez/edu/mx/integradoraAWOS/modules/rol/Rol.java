package utez.edu.mx.integradoraAWOS.modules.rol;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import utez.edu.mx.integradoraAWOS.modules.user.User;

import java.util.List;

@Entity
@Table(name = "rol")

public class Rol {
//----------------------------ATRIBUTOS PROPIOS DE LA CLASE----------------------------------------------
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

@Column(name = "id", nullable = false)
private long id;

    @Column(name="name", nullable = false)
    private String name;

    //----------------------------ATRIBUTOS DE RELACION con otras clases ----------------------------------------------
    @OneToMany(mappedBy = "rol")
    @JsonIgnore
    private List<User> users;


}
