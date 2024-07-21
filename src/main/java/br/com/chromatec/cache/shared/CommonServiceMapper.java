package br.com.chromatec.cache.shared;

public interface CommonServiceMapper<DTO, Entity> {
    DTO entityToDTO(Entity e);
    Entity dtoToEntity(DTO dto);
}
