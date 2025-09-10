package com.basededatosrecetas.recetas.Service;


import com.basededatosrecetas.recetas.Model.Comentario;
import com.basededatosrecetas.recetas.Repository.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public Comentario saveComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> getAllComentarios() {
        return comentarioRepository.findAll();
    }

    public Optional<Comentario> getComentarioById(Long id) {
        return comentarioRepository.findById(id);
    }

    public List<Comentario> getComentariosByRecetaId(Long recetaId) {
        return comentarioRepository.findByRecetaId(recetaId);
    }

    public List<Comentario> getComentariosByUsuarioId(Long usuarioId) {
        return comentarioRepository.findByUsuarioId(usuarioId);
    }

    public void deleteComentario(Long id) {
        comentarioRepository.deleteById(id);
    }
}
