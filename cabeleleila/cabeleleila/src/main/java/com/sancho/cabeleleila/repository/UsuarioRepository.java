package com.sancho.cabeleleila.repository;

import com.sancho.cabeleleila.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
