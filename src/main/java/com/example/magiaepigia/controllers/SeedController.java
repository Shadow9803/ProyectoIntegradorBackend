package com.example.magiaepigia.controllers;

import com.example.magiaepigia.models.Seed;
import com.example.magiaepigia.services.SeedService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saludapi/v1/seeds")
@Tag(name = "Controlador CRUD para los servicios web de seed" )
public class SeedController {

    @Autowired
    SeedService seedService;

    @PostMapping
    @Operation(summary = "Registrar una nueva semilla")
    @ApiResponses({
    @ApiResponse(responseCode = "201", description =  "Semilla creada con exito", 
        content = @Content(schema = @Schema(implementation = Seed.class))
    ),
    @ApiResponse(responseCode = "400", description = "Error en los datos de entrada",
    content = @Content(mediaType = "application/json", 
    examples = @ExampleObject(
        value = "{\"mensaje\":\"" + "Error en el nombre ingresado, revisa por favor\"}" 
    )

    )
) //no hay manejadores
})
    public ResponseEntity<Seed> guardar(@RequestBody Seed datos) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.seedService.save(datos));
    }

    @GetMapping
    public ResponseEntity<List<Seed>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(this.seedService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consultar una semilla por su ID")
    public ResponseEntity<Seed> buscarPorId(@PathVariable Long id) {
        // Como el servicio devuelve un Optional, usamos .orElse(null)
        // para que si no lo encuentra, devuelva vacío sin error.
        return ResponseEntity.status(HttpStatus.OK).body(this.seedService.getById(id).orElse(null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seed> actualizar(@PathVariable Long id, @RequestBody Seed datos) {
        return ResponseEntity.status(HttpStatus.OK).body(this.seedService.update(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        this.seedService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}