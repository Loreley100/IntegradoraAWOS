package utez.edu.mx.integradoraAWOS.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service // sirve para indicarle a sping que esta clase va a funcionar como servicico
public class CustomResponseEntity {
    private Map<String,Object> body; // el map k=key (nombre  de la cadena de texto, id, nombre que le damos al valor) value=v (valor almacenado)
// con mpa se especifica que para los nombre se hace uso el string y para el value el object

    //funcion= accseso tipo_dato_funcion nombre_funcion (tipo_dato nombre_p){} //argumento es la infromacon que se llama, parametro= cuando se define y especifica el tipo de dato
    public ResponseEntity<?> getOkResponse(String message, String status, int code, Object data) { //object--> almacena cualquier tipo de dato
        body = new HashMap<>();
        // body.put(k,v)
        body.put("message", message);
        body.put("status", status);
        body.put("code", code);
        if (data != null) {
            body.put("message", message);
        }
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
//tipo de dato del metodo es el repsonse entity, tipo de dato que va a reornar el metodo
// el return siempre va a trabbajar segun el tipo de dato que le pertecene al metodo

    public ResponseEntity<?> get400Response (){
        body = new HashMap<>();
        body.put("message", "Error al realizar la operacion");
        body.put("status", "BAD_REQUEST");
        body.put("code", 400);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<?> get404Response (){
        body = new HashMap<>();
        body.put("message", "Recurso no encontrado");
        body.put("status", "NOT_FOUND");
        body.put("code", 404);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
