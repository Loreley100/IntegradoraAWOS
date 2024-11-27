package utez.edu.mx.integradoraAWOS.modules.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import utez.edu.mx.integradoraAWOS.modules.user.User;

import java.util.List;

@Entity
@Table(name="grupo")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column (name="municipality", nullable = false)
    private String municipality;

    @Column (name="cologne", nullable = false)
    private String cologne;

    @Column (name="location", nullable = false)
    private String location;

    @OneToMany(mappedBy = "groupos")
    @JsonIgnore
    private List<User> users;

//
//    @OneToOne
//    @JoinColumn(name="id_user",referencedColumnName = "id")
//    private User user;


    public Group() {
    }

    public Group(long id, String name, String municipality, String cologne, String location, List<User> users) {
        this.id = id;
        this.name = name;
        this.municipality = municipality;
        this.cologne = cologne;
        this.location = location;
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

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getCologne() {
        return cologne;
    }

    public void setCologne(String cologne) {
        this.cologne = cologne;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
