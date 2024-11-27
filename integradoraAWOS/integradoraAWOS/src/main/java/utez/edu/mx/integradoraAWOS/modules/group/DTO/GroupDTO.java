package utez.edu.mx.integradoraAWOS.modules.group.DTO;


import utez.edu.mx.integradoraAWOS.modules.rol.Rol;

// PLANTILLA DE TRANSFERENCIA
public class GroupDTO {

    private long id;
    private String name, municipality, cologne, location;
//Solo vamos a usar dos constructpres, uno vacio para no tener que mandar null  y uno con todoo
    public GroupDTO() {
    }

    public GroupDTO(long id, String name, String municipality, String cologne, String location) {
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
