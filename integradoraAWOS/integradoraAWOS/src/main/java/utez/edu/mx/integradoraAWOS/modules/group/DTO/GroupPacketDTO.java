package utez.edu.mx.integradoraAWOS.modules.group.DTO;
// PLANTILLA DE TRANSFERENCIA PARA RECUPERAR USUARIOS EN PAQUETES
public class GroupPacketDTO {

    private long id;
    private String name, municipality, cologne, location;

    public GroupPacketDTO() {
    }

    public GroupPacketDTO(long id, String name, String municipality, String cologne, String location) {
        this.id = id;
        this.name = name;
        this.municipality = municipality;
        this.cologne = cologne;
        this.location = location;
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
}
