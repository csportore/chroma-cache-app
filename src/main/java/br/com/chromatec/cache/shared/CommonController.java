package br.com.chromatec.cache.shared;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public abstract class CommonController<D, R, E, EID> {
    private final CommonControllerMapper<D,R> mapper;
    private final CommonService<D, E, EID> service;

    public CommonController(CommonControllerMapper<D,R> mapper, CommonService<D, E, EID> service) {
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> insert(R representation) {
        try {
            var dto = this.mapper.representationToDTO(representation);
            var result = this.service.insert(dto);
            return ResponseEntity.ok().body(this.mapper.dtoToRepresentation(result));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OMG - POST");
        }
    }

}
