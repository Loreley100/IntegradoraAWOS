package utez.edu.mx.integradoraAWOS.modules.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.integradoraAWOS.modules.type.DTO.TypeDTO;
import utez.edu.mx.integradoraAWOS.utils.CustomResponseEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService {
    @Autowired TypeRepository typeRepository;

    @Autowired
    private CustomResponseEntity customResponseEntity;

    public TypeDTO transformTypeToDTO(Type t) {
        return new TypeDTO (
                t.getId(),
                t.getName()
        );
    }


    @Transactional(readOnly = true)
    public ResponseEntity<?> findAll(){
        List<TypeDTO> list = new ArrayList<>();
        String message = "";

        if(typeRepository.findAll().isEmpty()) {
            message = "Aun no hay registros";
        } else {
            message = "Operacion exitosa";
            for (Type t : typeRepository.findAll()) {
                list.add(transformTypeToDTO(t));
            }
        }
        return customResponseEntity.getOkResponse(message, "OK", 200, list);
    }


    @Transactional(readOnly = true)
    public ResponseEntity<?> findById(long id) {
        TypeDTO dto = null;
        Type found = typeRepository.findById(id);
        String message = "";
        if(found == null) {
            return customResponseEntity.get404Response();
        } else {
            message = "Operacion exitosa";
            dto = transformTypeToDTO(found);

            return customResponseEntity.getOkResponse(
                    message, "OK", 200, dto
            );
        }
    }


    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> save(Type type) {
        try{
            typeRepository.save(type);
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


    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> update(long id, Type type) {
        Type found = typeRepository.findById(type.getId());
        if(found == null) {
            return customResponseEntity.get404Response();
        } else {
            try {
                typeRepository.save(type);
                return customResponseEntity.getOkResponse("Actualizacion exitosa", "OK", 200, null);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                return customResponseEntity.get400Response();
            }
        }
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> deleteById(long id) {
        if(typeRepository.findById(id) == null) {
            return customResponseEntity.get404Response();
        } else {
            try {
                typeRepository.deleteById(id);
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
