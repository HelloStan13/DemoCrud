package com.crud.democrud.dao;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.repositories.UsuarioRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface usuarioDao extends CrudRepository<UsuarioModel, Long> {
    @Modifying
    @Query("update UsuarioModel set nombre = :nombre where id = :id")
    public void actualizaNombre(
            @Param(value = "id") Long id,
            @Param(value = "nombre") String nombre
    );
}
