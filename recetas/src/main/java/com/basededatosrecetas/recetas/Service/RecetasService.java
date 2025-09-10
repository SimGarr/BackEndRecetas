package com.basededatosrecetas.recetas.Service;

import com.basededatosrecetas.recetas.Model.Recetas;
import com.basededatosrecetas.recetas.Repository.RecetasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetasService {

    @Autowired
    private RecetasRepository recetasRepository;

    // Obtener todas las recetas
    public List<Recetas> getAllRecetas() {
        return recetasRepository.findAll();
    }

    // Obtener recetas por categoría
    public List<Recetas> getRecetasByCategoria(String categoria) {
        return recetasRepository.findByCategoria(categoria);
    }

    // Obtener receta por ID
    public Optional<Recetas> getRecetaById(Long id) {
        return recetasRepository.findById(id);
    }

    // Crear nueva receta
    public Recetas createReceta(Recetas receta) {
        return recetasRepository.save(receta);
    }

    // Actualizar receta
    public Optional<Recetas> updateReceta(Long id, Recetas recetaDetails) {
        return recetasRepository.findById(id).map(receta -> {
            receta.setNombre(recetaDetails.getNombre());
            receta.setDescripcion(recetaDetails.getDescripcion());
            receta.setCategoria(recetaDetails.getCategoria());
            receta.setImagenUrl(recetaDetails.getImagenUrl());
            receta.setTiempoPreparacion(recetaDetails.getTiempoPreparacion());
            receta.setCalificacionPromedio(recetaDetails.getCalificacionPromedio());
            return recetasRepository.save(receta);
        });
    }

    // Eliminar receta
    public boolean deleteReceta(Long id) {
        return recetasRepository.findById(id).map(receta -> {
            recetasRepository.delete(receta);
            return true;
        }).orElse(false);
    }
}
