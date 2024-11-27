package utez.edu.mx.integradoraAWOS.modules.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/type")
public class TypeController {
    // ------------------ INYECCIÓN DE SERVICIOS ------------------
    @Autowired
    private TypeService typeService;
    @GetMapping("")
    public ResponseEntity<?> findAll(){
        return typeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id){
        return typeService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Type type){
        return typeService.save(type);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Type type){
        return typeService.update(id, type);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        return typeService.deleteById(id);
    }
}
