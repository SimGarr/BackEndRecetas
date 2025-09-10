package com.basededatosrecetas.recetas.Service;


import com.basededatosrecetas.recetas.Model.Historial;
import com.basededatosrecetas.recetas.Repository.HistorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialService {

    private final HistorialRepository historialRepository;

    public HistorialService(HistorialRepository historialRepository) {
        this.historialRepository = historialRepository;
    }

    public Historial addHistorial(Historial historial) {
        return historialRepository.save(historial);
    }

    public List<Historial> getHistorialByUsuario(Long usuarioId) {
        return historialRepository.findByUsuarioId(usuarioId);
    }

    public List<Historial> getHistorialByReceta(Long recetaId) {
        return historialRepository.findByRecetaId(recetaId);
    }
}
