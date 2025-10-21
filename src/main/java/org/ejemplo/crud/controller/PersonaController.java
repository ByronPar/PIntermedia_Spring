package org.ejemplo.crud.controller;
import org.ejemplo.crud.model.Persona;
import org.ejemplo.crud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "*")
public class PersonaController {

    @Autowired
    private PersonaRepository repo;

    @GetMapping
    public List<Persona> listar() {
        return repo.findAll();
    }
    @GetMapping("/{id}")
    public Persona obtener(@PathVariable Integer id) {
        return repo.findById(id).orElse(null);
    }
    @PostMapping
    public Persona crear(@RequestBody Persona persona) {
        return repo.save(persona);
    }
    @PutMapping("/{id}")
    public Persona actualizar(@PathVariable Integer id, @RequestBody Persona p) {
        Persona persona = repo.findById(id).orElse(null);
        if (persona != null) {
            persona.setNombre(p.getNombre());
            persona.setCorreo(p.getCorreo());
            return repo.save(persona);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}
