package utez.edu.mx.integradoraAWOS.modules.type.DTO;

// PLANTILLA DE TRANSFERENCIA PARA RECUPERAR USUARIOS
public class TypeDTO {

    private long id;
    private String name;

    //Solo vamos a usar dos constructpres, uno vacio para no tener que mandar null  y uno con todo


    public TypeDTO() {
    }

    public TypeDTO(long id, String name) {
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
