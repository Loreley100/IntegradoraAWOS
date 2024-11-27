package utez.edu.mx.integradoraAWOS.modules.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.integradoraAWOS.modules.group.DTO.GroupDTO;
import utez.edu.mx.integradoraAWOS.utils.CustomResponseEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private CustomResponseEntity customResponseEntity;
    public GroupDTO transformGroupToDTO(Group g) {
        return new GroupDTO(
                g.getId(),
                g.getName(),
                g.getMunicipality(),
                g.getCologne(),
                g.getLocation()
        );
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> findAll(){
        List<GroupDTO> list = new ArrayList<>();
        String message = "";

        if(groupRepository.findAll().isEmpty()) {
            message = "Aun no hay registros";
        } else {
            message = "Operacion exitosa";
            for (Group g : groupRepository.findAll()) {
                list.add(transformGroupToDTO(g));
            }
        }
        return customResponseEntity.getOkResponse(message, "OK", 200, list);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> findById(long id) {
        GroupDTO dto = null;
        Group found = groupRepository.findById(id);
        String message = "";
        if(found == null) {
            return customResponseEntity.get404Response();
        } else {
            message = "Operacion exitosa";
            dto = transformGroupToDTO(found);

            return customResponseEntity.getOkResponse(
                    message, "OK", 200, dto
            );
        }
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> save(Group group) {
        try{
            groupRepository.save(group);
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
    public ResponseEntity<?> update(long id, Group group) {
        Group found = groupRepository.findById(group.getId());
        if(found == null) {
            return customResponseEntity.get404Response();
        } else {
            try {
                groupRepository.save(group);
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
        if(groupRepository.findById(id) == null) {
            return customResponseEntity.get404Response();
        } else {
            try {
                groupRepository.deleteById(id);
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
