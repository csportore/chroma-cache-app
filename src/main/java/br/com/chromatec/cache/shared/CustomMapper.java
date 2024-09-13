package br.com.chromatec.cache.shared;
import org.mapstruct.Mapping;
import java.time.LocalDateTime;
import java.util.List;


public interface CustomMapper<D, E, R, ID> {

    D entityToDTO(E entity, ID id);
    D entityToDTO(E entity);
    List<D> entityListToDTOList(Iterable<E> entityList);
    D representationToDTO(ID id, R representation);
    List<D> representationListToDTOList(List<R> representationList);

    R dtoToRepresentation(D dto);
    List<R> dtoToRepresentationList(List<D> dtoList);

    // Example how to add extra properties with MapStruct
    @Mapping(target="registrationDateTime", source = "registrationDateTime")
    E dtoToEntity(D dto, LocalDateTime registrationDateTime);
    @Mapping(target="registrationDateTime", source = "registrationDateTime")
    E dtoToEntity(ID id, D dto, LocalDateTime registrationDateTime);
    List<E> dtoToEntityList(Iterable<D> dtoList);
}
