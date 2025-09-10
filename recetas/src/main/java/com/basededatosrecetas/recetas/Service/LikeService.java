package com.basededatosrecetas.recetas.Service;

import com.basededatosrecetas.recetas.Model.Like;
import com.basededatosrecetas.recetas.Repository.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public Like addLike(Like like) {
        if (likeRepository.existsByUsuarioIdAndRecetaId(like.getUsuario().getId(), like.getReceta().getId())) {
            return null; // o lanzar excepción
        }
        return likeRepository.save(like);
    }

    public List<Like> getLikesByUsuario(Long usuarioId) {
        return likeRepository.findByUsuarioId(usuarioId);
    }

    public List<Like> getLikesByReceta(Long recetaId) {
        return likeRepository.findByRecetaId(recetaId);
    }
}
