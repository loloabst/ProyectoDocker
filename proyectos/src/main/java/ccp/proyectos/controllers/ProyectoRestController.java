package ccp.proyectos.controllers;

import ccp.proyectos.entities.Proyecto;
import ccp.proyectos.services.ProyectoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/proyectos")
public class ProyectoRestController {
    @Autowired
    private ProyectoServicio proyectoServicio;

    @GetMapping("/")
    public ResponseEntity<List<Proyecto>> getAllProyectos() {
        return new ResponseEntity<>(proyectoServicio.listarProyectos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> getProyecto(@PathVariable Long id) {
        Proyecto proyecto = proyectoServicio.buscarProyectoPorId(id).orElse(null);
        if (proyecto != null) {
            return new ResponseEntity<>(proyecto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Proyecto> createProyecto(@RequestBody @Valid Proyecto proyecto) {
        Proyecto nuevo = proyectoServicio.crearProyecto(proyecto);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> noExisteProyecto() {
        return new ResponseEntity<>("End Point No Soportado",HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Proyecto> actualizaParcial(@PathVariable Long id, @RequestBody @Valid Proyecto proyecto) {
        Proyecto existente = proyectoServicio.buscarProyectoPorId(id).orElse(null);
        if (existente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (proyecto.getNombre() != null) existente.setNombre(proyecto.getNombre());
        if (proyecto.getDescripcion() != null) existente.setDescripcion(proyecto.getDescripcion());
        if (proyecto.getFechaInicio() != null) existente.setFechaInicio(proyecto.getFechaInicio());
        if (proyecto.getEstado() != null) existente.setEstado(proyecto.getEstado());
        if (proyecto.getResponsable() != null) existente.setResponsable(proyecto.getResponsable());
        if (proyecto.getPresupuesto() != null) existente.setPresupuesto(proyecto.getPresupuesto());

        Proyecto actualizado = proyectoServicio.actualizarProyecto(existente);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> editar(@PathVariable Long id, @RequestBody @Valid Proyecto proyecto) {
        proyecto.setId(id);
        Proyecto actualizado = proyectoServicio.actualizarProyecto(proyecto);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Proyecto> eliminar(@PathVariable Long id) {
        Proyecto eliminado = proyectoServicio.eliminarProyecto(id);
        if (eliminado != null) {
            return new ResponseEntity<>(eliminado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
