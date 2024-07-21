package br.com.chromatec.cache.shared;

public interface CommonControllerMapper<D, R> {
    D representationToDTO(R representation);
    R dtoToRepresentation(D dto);
}
