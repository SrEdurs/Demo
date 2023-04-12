package es.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.demo.model.Pagina;

public interface PaginaRepository extends JpaRepository<Pagina,Long> {
    
    //encontrar por id
    Pagina findById(int id);
}
