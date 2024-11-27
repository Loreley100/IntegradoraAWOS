package utez.edu.mx.integradoraAWOS.modules.event.DTO;
// PLANTILLA DE TRANSFERENCIA PARA RECUPERAR USUARIOS EN PAQUETES
public class EventPacketDTO {

private long id;
private String name, title, date, status;

    public EventPacketDTO() {
    }

    public EventPacketDTO(long id, String name, String title, String date, String status) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.date = date;
        this.status = status;
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
}
