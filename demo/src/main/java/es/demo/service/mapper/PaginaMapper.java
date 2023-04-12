package es.demo.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import es.demo.dto.PaginaDto;
import es.demo.model.Pagina;

@Service
public class PaginaMapper extends AbstractServiceMapper<Pagina,PaginaDto> {
    
    @Override
   public PaginaDto toDto(Pagina entidad){
        final PaginaDto dto = new PaginaDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }

    //Convertir de dto a entidad
    @Override
    public Pagina toEntity(PaginaDto dto){
        final Pagina entidad = new Pagina();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, entidad);
        return entidad;
    }


    public PaginaMapper() {
    }
}
