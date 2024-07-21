package br.com.chromatec.cache.shared;

import org.springframework.data.repository.CrudRepository;

public abstract class CommonService<D, E, EID> {

    private final CommonServiceMapper<D, E> mapper;
    private final CrudRepository<E, EID> repository;

    public CommonService(CommonServiceMapper<D, E> mapper,
                         CrudRepository<E, EID> repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public D insert(D d) {
        var entity = this.mapper.dtoToEntity(d);
        return this.mapper.entityToDTO(this.repository.save(entity));
    }


}
