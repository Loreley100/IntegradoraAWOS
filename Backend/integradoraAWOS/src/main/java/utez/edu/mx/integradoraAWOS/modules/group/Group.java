package utez.edu.mx.integradoraAWOS.modules.group;

import jakarta.persistence.*;
import utez.edu.mx.integradoraAWOS.modules.user.User;

import java.util.List;

@Entity
@Table(name="group")
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
    private String email;

    @ManyToMany
    @JoinTable(
            name="group_has_article",
            joinColumns =@JoinColumn (name= "id_group"),
            inverseJoinColumns = @JoinColumn(name="id_user")
    )
    private List<User> users;

    public Group() {
    }

    public Group(long id, String name, String municipality, String cologne, String email, List<User> users) {
        this.id = id;
        this.name = name;
        this.municipality = municipality;
        this.cologne = cologne;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
