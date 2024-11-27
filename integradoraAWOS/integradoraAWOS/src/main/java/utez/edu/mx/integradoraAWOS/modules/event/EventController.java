package utez.edu.mx.integradoraAWOS.modules.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/event")
public class EventController {
    // ------------------ INYECCIÓN DE SERVICIOS ------------------
    @Autowired
    private EventService eventService;
    @GetMapping("")
    @Secured({"ROLE_ADMIN","ROLE_ADMINGROUPS"})
    public ResponseEntity<?> findAll(){
        return eventService.findAll();
    }

    @GetMapping("/{id}")
    @Secured({"ROLE_ADMIN","ROLE_ADMINGROUPS"})
    public ResponseEntity<?> findById(@PathVariable long id){
        return eventService.findById(id);
    }

    @PostMapping("")
    @Secured({"ROLE_ADMIN","ROLE_ADMINGROUPS"})
    public ResponseEntity<?> save(@RequestBody Event event){
        return eventService.save(event);
    }

    @PutMapping("/{id}")
    @Secured({"ROLE_ADMIN","ROLE_ADMINGROUPS"})
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Event event){
        return eventService.update(id, event);
    }

//    @PutMapping("/{id}")
//    @Secured({"ROLE_MEMBER"})
//    public ResponseEntity<?> confirmAsistencia(@PathVariable long id, @RequestBody Event event){
//        return eventService.update(id, event);
//    }

    @DeleteMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> delete(@PathVariable long id){
        return eventService.deleteById(id);
    }
}
