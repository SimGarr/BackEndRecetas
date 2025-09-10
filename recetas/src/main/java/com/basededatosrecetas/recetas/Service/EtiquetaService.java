package com.basededatosrecetas.recetas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.basededatosrecetas.recetas.Model.Etiqueta;
import com.basededatosrecetas.recetas.Model.RecetaEtiqueta;
import com.basededatosrecetas.recetas.Repository.EtiquetaRepository;
import com.basededatosrecetas.recetas.Repository.RecetaEtiquetaRepository;

@Service
public class EtiquetaService {

    private final EtiquetaRepository etiquetaRepository;
    private final RecetaEtiquetaRepository recetaEtiquetaRepository;

    public EtiquetaService(EtiquetaRepository etiquetaRepository, RecetaEtiquetaRepository recetaEtiquetaRepository) {
        this.etiquetaRepository = etiquetaRepository;
        this.recetaEtiquetaRepository = recetaEtiquetaRepository;
    }

    public Etiqueta saveEtiqueta(Etiqueta etiqueta) {
        return etiquetaRepository.save(etiqueta);
    }

    public List<Etiqueta> getAllEtiquetas() {
        return etiquetaRepository.findAll();
    }

    public Optional<Etiqueta> getEtiquetaById(Long id) {
        return etiquetaRepository.findById(id);
    }

    public void deleteEtiqueta(Long id) {
        etiquetaRepository.deleteById(id);
    }

    public RecetaEtiqueta addEtiquetaToReceta(RecetaEtiqueta recetaEtiqueta) {
        return recetaEtiquetaRepository.save(recetaEtiqueta);
    }

    public List<RecetaEtiqueta> getEtiquetasByReceta(Long recetaId) {
        return recetaEtiquetaRepository.findByRecetaId(recetaId);
    }

    public List<RecetaEtiqueta> getRecetasByEtiqueta(Long etiquetaId) {
        return recetaEtiquetaRepository.findByEtiquetaId(etiquetaId);
    }
}
