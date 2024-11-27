package utez.edu.mx.integradoraAWOS.modules.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.integradoraAWOS.modules.event.DTO.EventDTO;
import utez.edu.mx.integradoraAWOS.utils.CustomResponseEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CustomResponseEntity customResponseEntity;
    public EventDTO transformEventToDTO(Event e) {
        return new EventDTO (
                e.getId(),
                e.getTitle(),
                e.getDate(),
                e.getStatus()
        );
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> findAll(){
        List<EventDTO> list = new ArrayList<>();
        String message = "";
        if(eventRepository.findAll().isEmpty()) {
            message = "Aun no hay registros";
        } else {
            message = "Operacion exitosa";
            for (Event e : eventRepository.findAll()) {
                list.add(transformEventToDTO(e));
            }
        }
        return customResponseEntity.getOkResponse(message, "OK", 200, list);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> findById(long id) {
        EventDTO dto = null;
        Event found = eventRepository.findById(id);
        String message = "";
        if(found == null) {
            return customResponseEntity.get404Response();
        } else {
            message = "Operacion exitosa";
            dto = transformEventToDTO(found);

            return customResponseEntity.getOkResponse(
                    message, "OK", 200, dto
            );
        }
    }



//    @Transactional(rollbackFor = {SQLException.class, Exception.class})
//    public ResponseEntity<?> confirmasAsistencia(long id, Event event) {
//        Event found = eventRepository.findById(event.getId());
//        if(found == null) {
//            return customResponseEntity.get404Response();
//        } else {
//            try {
//                eventRepository.save(event);
//                return customResponseEntity.getOkResponse("Asistencia confirmada", "OK", 200, null);
//            } catch (Exception e) {
//                e.printStackTrace();
//                System.out.println(e.getMessage());
//                return customResponseEntity.get400Response();
//            }
//        }
//    }





    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> save(Event event) {
        try{
            eventRepository.save(event);
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
    public ResponseEntity<?> update(long id, Event event) {
        Event found = eventRepository.findById(event.getId());
        if(found == null) {
            return customResponseEntity.get404Response();
        } else {
            try {
                eventRepository.save(event);
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
        if(eventRepository.findById(id) == null) {
            return customResponseEntity.get404Response();
        } else {
            try {
                eventRepository.deleteById(id);
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
