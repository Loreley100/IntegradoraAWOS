package utez.edu.mx.integradoraAWOS.modules.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import utez.edu.mx.integradoraAWOS.modules.event.Event;
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

    @Column (name="lastname", nullable = false)
    private String lastname;

    @Column (name="surname", nullable = false)
    private String surname;

    @Column (name="email", nullable = false, unique = true)
    private String email;

    @Column (name="phone", nullable = false, unique = true)
    private String phone;

    @Column (name="username", nullable = false, unique = true)
    private String username;

    @Column (name="password", nullable = false)
    private String password;

    //----------------------------ATRIBUTOS DE RELACION----------------------------------------------
    @ManyToOne
    @JoinColumn (name="id_rol")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name="id_group")
    private Group groupos;



    //---------------- muchos a muchos---------------
    @ManyToMany(mappedBy = "userss")
    private List<Event> events;



//    //----------------------relacion uno a muchos ---------------------------
//
//    @OneToMany (mappedBy = "users")
//    @JsonIgnore
//    private List<Event> event;

// ---------------------------------------------------------------------------

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private Group grouposs;

    public User() {
    }

    public User(long id, String name, String lastname, String surname, String email, String phone, String username, String password, Rol rol, Group groupos, List<Event> events) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.groupos = groupos;
        this.events = events;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Group getGroupos() {
        return groupos;
    }

    public void setGroupos(Group groupos) {
        this.groupos = groupos;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
