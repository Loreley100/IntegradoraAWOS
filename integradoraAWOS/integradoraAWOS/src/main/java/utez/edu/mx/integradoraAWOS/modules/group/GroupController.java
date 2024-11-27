package utez.edu.mx.integradoraAWOS.modules.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/group")
public class GroupController {
    // ------------------ INYECCIÓN DE SERVICIOS ------------------
    @Autowired
    private GroupService groupService;
    @GetMapping("")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> findAll(){
        return groupService.findAll();
    }

    @GetMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> findById(@PathVariable long id){
        return groupService.findById(id);
    }

    @PostMapping("")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> save(@RequestBody Group group){
        return groupService.save(group);
    }

    @PutMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Group group){
        return groupService.update(id, group);
    }

    @DeleteMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> delete(@PathVariable long id){
        return groupService.deleteById(id);
    }

}
