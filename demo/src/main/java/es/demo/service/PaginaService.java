package es.demo.service;

import org.springframework.stereotype.Service;

import es.demo.dto.PaginaDto;
import es.demo.model.Pagina;
import es.demo.repository.PaginaRepository;
import es.demo.service.mapper.PaginaMapper;

@Service
public class PaginaService extends AbstractBusinessService<Pagina, Integer, PaginaDto, PaginaRepository, PaginaMapper> {

    public PaginaService(PaginaRepository repo, PaginaMapper mapper) {
        super(repo, mapper);
    }

    public Pagina findById(int i) {
        return null;
    }
}