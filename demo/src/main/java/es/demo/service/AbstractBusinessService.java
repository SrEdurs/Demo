package es.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import es.demo.service.mapper.AbstractServiceMapper;
import java.util.*;

public abstract class AbstractBusinessService <E, ID, DTO,  REPO extends JpaRepository<E,Long> ,
        MAPPER extends AbstractServiceMapper<E,DTO>> {
    private final REPO repo;
    private final MAPPER serviceMapper;


    protected AbstractBusinessService(REPO repo, MAPPER mapper) {
        this.repo = repo;
        this.serviceMapper = mapper;
    }
    //Lista de todos los DTOs buscarTodos devolvera lista
    public List<DTO> buscarTodos(){
        return  this.serviceMapper.toDto(this.repo.findAll());
    }

    public List<E> buscarEntidades(){
        return  this.repo.findAll();
    }

    //Buscar por id
    public Optional<DTO> encuentraPorId(long l){

        return this.repo.findById(l).map(this.serviceMapper::toDto);
    }
    public Optional<E> encuentraPorIdEntity(long id){

        return this.repo.findById(id);
    }
    //Guardar
    public DTO guardar(DTO dto) throws Exception {
        //Traduzco del dto con datos de entrada a la entidad
        final E entidad = serviceMapper.toEntity(dto);
        //Guardo el la base de datos
        E entidadGuardada =  repo.save(entidad);
        //Traducir la entidad a DTO para devolver el DTO
        return serviceMapper.toDto(entidadGuardada);
    }

    //Obtener el mapper
    public MAPPER getMapper(){return  serviceMapper;}
    //Obtener el repo
    public REPO getRepo(){return  repo;}
}