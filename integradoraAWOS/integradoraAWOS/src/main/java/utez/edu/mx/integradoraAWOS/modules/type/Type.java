package utez.edu.mx.integradoraAWOS.modules.type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import utez.edu.mx.integradoraAWOS.modules.event.Event;

import java.util.List;

@Entity
@Table(name="type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id", nullable = false)
    private long id;

    @Column(name="name", nullable = false)
    private String name;



    @OneToMany (mappedBy = "type")
    @JsonIgnore
    private List<Event> event;

    public Type() {
    }

    public Type(long id, String name, List<Event> event) {
        this.id = id;
        this.name = name;
        this.event = event;
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

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }
}
