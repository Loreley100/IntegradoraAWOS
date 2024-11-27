package utez.edu.mx.integradoraAWOS.modules.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    // ------------------ INYECCIÓN DE SERVICIOS ------------------
    @Autowired
    private UserService userService;

    @Secured("ROLE_ADMIN")
    @GetMapping("")
    public ResponseEntity<?> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @Secured({"ROLE_ADMIN","ROLE_ADMINGROUPS"})
    public ResponseEntity<?> findById(@PathVariable long id){
        return userService.findById(id);
    }

    @PostMapping("")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> save(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody User user){
        return userService.update(id, user);}

    @DeleteMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> delete(@PathVariable long id){
        return userService.deleteById(id);
    }

}
