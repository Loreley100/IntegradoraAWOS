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

    public Rol() {
    }

    public Rol(long id, String name, List<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
