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
    private List<Event> board;
}
