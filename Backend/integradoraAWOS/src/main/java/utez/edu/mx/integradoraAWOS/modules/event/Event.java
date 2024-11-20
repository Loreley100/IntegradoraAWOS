package utez.edu.mx.integradoraAWOS.modules.event;

import jakarta.persistence.*;
import utez.edu.mx.integradoraAWOS.modules.type.Type;

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

    //realcion con type ManytoOne
    @ManyToOne
    @JoinColumn(name="id_type", nullable = false)
    private Type type;

    public Event() {
    }
}
