package utez.edu.mx.integradoraAWOS.modules.type.DTO;
// PLANTILLA DE TRANSFERENCIA PARA RECUPERAR USUARIOS EN PAQUETES
public class TypePacketDTO {

private long id;
private String name;

    public TypePacketDTO() {
    }

    public TypePacketDTO(long id, String name) {
        this.id = id;
        this.name = name;
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

}
