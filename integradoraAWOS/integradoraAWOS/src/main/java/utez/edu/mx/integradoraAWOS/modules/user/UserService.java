package utez.edu.mx.integradoraAWOS.modules.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.integradoraAWOS.modules.user.DTO.UserDTO;
import utez.edu.mx.integradoraAWOS.utils.CustomResponseEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {
    // --------------------- INYECCIONES DE SERVIDOR -------------------------
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomResponseEntity customResponseEntity;
    // -------------------- METODOS DEL SERVICIO -----------------------------
    public UserDTO transformUserToDTO(User u) {
        return new UserDTO (
                u.getId(),
                u.getName(),
                u.getSurname(),
                u.getLastname(),
                u.getEmail(),
                u.getUsername(),
                u.getRol()
        );
    }



    // -------------------REGLAS DE NEGOCIO --------------------------

    // TRAER TODOS LOS USUARIOS
    // 1.- Colocar nuestra anotacion @Transactional <- spring
    @Transactional(readOnly = true)
    // 2.- Definir la funcion
    public ResponseEntity<?> findAll(){
        // 3.- Definir las variables locales
        // Lista de plantillas (DTOs)
        List<UserDTO> list = new ArrayList<>();
        // Mensaje de respuesta
        String message = "";

        // 4.- Preguntar si la lista esta vacia
        if(userRepository.findAll().isEmpty()) {
            // 4.1.- Si esta vacia indicar que esta vacia
            message = "Aun no hay registros";
        } else {
            // 4.2.- De lo contrario, indicar que NO esta vacia
            message = "Operacion exitosa";
            // 4.3.- Transformar todos los usuarios a mi plantilla
            // Para user itera todos los elementos de mi lista de usuarios
            for (User u : userRepository.findAll()) {
                // 1: TRANSFORMO, 2: AGREGO A LA LISTA
                list.add(transformUserToDTO(u));
            }
        }
        // 5.- Enviar la respuesta
        return customResponseEntity.getOkResponse(message, "OK", 200, list);
    }




    // TRAER A UN USUARIO POR SU ID
    @Transactional(readOnly = true)
    public ResponseEntity<?> findById(long id) {
        UserDTO dto = null;
        User found = userRepository.findById(id);
        String message = "";
        if(found == null) {
            return customResponseEntity.get404Response();
        } else {
            message = "Operacion exitosa";
            dto = transformUserToDTO(found);

            return customResponseEntity.getOkResponse(
                    message, "OK", 200, dto
            );
        }
    }



    // GUARDAR UN USUARIO
    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> save(User user) {
        try{
            userRepository.save(user);
            return customResponseEntity.getOkResponse(
                    "Registro exitoso",
                    "CREATED",
                    201,
                    null
            );
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return customResponseEntity.get400Response();
        }
    }




    // ACTUALIZAR UN USUARIO
    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> update(long id, User user) {
        User found = userRepository.findById(user.getId());
        if(found == null) {
            return customResponseEntity.get404Response();
        } else {
            try {
                user.setPassword(found.getPassword());
                userRepository.save(user);
                return customResponseEntity.getOkResponse("Actualizacion exitosa", "OK", 200, null);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                return customResponseEntity.get400Response();
            }
        }
    }

    // ELIMINAR UN USUARIO
    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> deleteById(long id) {
        if(userRepository.findById(id) == null) {
            return customResponseEntity.get404Response();
        } else {
            try {
                userRepository.deleteById(id);
                return customResponseEntity.getOkResponse(
                        "Eliminacion exitosa",
                        "OK",
                        200,
                        null
                );
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                return customResponseEntity.get400Response();
            }
        }
    }
}