package com.basededatosrecetas.recetas.Service;


import com.basededatosrecetas.recetas.Model.Favorito;
import com.basededatosrecetas.recetas.Repository.FavoritoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritoService {

    private final FavoritoRepository favoritoRepository;

    public FavoritoService(FavoritoRepository favoritoRepository) {
        this.favoritoRepository = favoritoRepository;
    }

    public List<Favorito> getFavoritosByUsuario(Long usuarioId) {
        return favoritoRepository.findByUsuarioId(usuarioId);
    }

    public Favorito agregarFavorito(Favorito favorito) {
        return favoritoRepository.save(favorito);
    }

    public void eliminarFavorito(Long usuarioId, Long recetaId) {
        favoritoRepository.deleteByUsuarioIdAndRecetaId(usuarioId, recetaId);
    }
}
