package utez.edu.mx.integradoraAWOS.modules.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import utez.edu.mx.integradoraAWOS.modules.group.Group;
import utez.edu.mx.integradoraAWOS.modules.rol.Rol;

import java.util.List;

@Entity
@Table (name = "user")
public class User {
    //----------------------------ATRIBUTOS PROPIOS DE LA CLASE----------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable = false)
    private long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column (name="surname", nullable = false)
    private String surname;

    @Column (name="lastname")
    private String lastname;

    @Column (name="email", nullable = false, unique = true)
    private String email;

    @Column (name="phone", nullable = false, unique = true)
    private String phone;

    @Column (name="username", nullable = false)
    private String username;

    @Column (name="password", nullable = false)
    private String password;

    //----------------------------ATRIBUTOS DE RELACION----------------------------------------------
    @ManyToOne
    @JoinColumn (name="id_rol", nullable = false)
private Rol rol;

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private List<Group> groups;

    public User() {
    }

}
