package utez.edu.mx.integradoraAWOS.modules.event;

import jakarta.persistence.*;
import utez.edu.mx.integradoraAWOS.modules.type.Type;
import utez.edu.mx.integradoraAWOS.modules.user.User;

import java.util.List;

@Entity
@Table(name= "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column (name="date", nullable = false)
    private String date;

    @Column (name="status", nullable = false)
    private String status;



//---------------- muchos a muchos---------------

    @ManyToMany
    @JoinTable(name="event_has_users",
            joinColumns=@JoinColumn(name="id_event"),
            inverseJoinColumns = @JoinColumn(name="id_user")
    )
    private List<User> userss;

    //-------------------
//
//    @ManyToOne
//    @JoinColumn//(name="id_users")
//    private User users;

    //realcion con type ManytoOne
    @ManyToOne
    @JoinColumn(name="id_type")
    private Type type;

    public Event() {
    }


    public Event(long id, String title, String date, String status, List<User> userss, Type type) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.status = status;
        this.userss = userss;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getUserss() {
        return userss;
    }

    public void setUserss(List<User> userss) {
        this.userss = userss;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
