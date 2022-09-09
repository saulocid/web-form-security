package tk.leooresende01.webformsecurity.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tk.leooresende01.webformsecurity.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{

}
