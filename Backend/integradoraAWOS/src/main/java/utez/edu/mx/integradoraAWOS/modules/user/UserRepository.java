package utez.edu.mx.integradoraAWOS.modules.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //TRAE TODOS LOS USUARIOS
    List<User> findAll();

    // PARA HACER UNA  CONSULTA PERONALIZADA
    @Query(value = "SELECT * FROM user WHERE id_rol = :idRol", nativeQuery = true)
    List<User> findAllByRol(@Param("idRol") long idRol);

    //TRAER UN USUARIO POR ID
    User findById(long idUser);

    //GUARDAR/ACTUALIZAR USUARIO
    User save (User user);

    //ELIMINAR USUARIO

    @Modifying ////INDICA QUE LA CONSULTA REALIZARA CAMBIOS EN LA BASE DE DATOS
    @Query(value = "DELETE FROM user WHERE id= :idUser", nativeQuery = true)
    void deleteById (@Param("idUser")long idUser);


// Buscar usuario por usuario/correo y contraseña
    @Query(value = "SELECT * FROM user " +
            "WHERE password = :password " +
            "AND (email = :username OR username = :username);",
            nativeQuery = true)
    User findByPasswordAndEmailOrUsername(
            @Param("password") String password,
            @Param("username") String username
    );

    // Buscar usuario por nombre de usuario
    User findByUsername(String username);
}
