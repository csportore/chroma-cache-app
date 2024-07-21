package br.com.chromatec.cache.professionals;

import br.com.chromatec.cache.shared.CommonControllerMapper;
import br.com.chromatec.cache.shared.CommonServiceMapper;

public class ProfessionalsMapper implements CommonControllerMapper<ProfessionalDTO, ProfessionalRepresentation>,
        CommonServiceMapper<ProfessionalDTO, Professional> {

    public static ProfessionalsMapper INSTANCE = new ProfessionalsMapper();

    private ProfessionalsMapper(){}

    @Override
    public ProfessionalDTO representationToDTO(ProfessionalRepresentation representation) {
        var dto = new ProfessionalDTO();
        dto.setProfession(representation.getProfession());
        dto.setName(representation.getName());
        return dto;
    }

    @Override
    public ProfessionalRepresentation dtoToRepresentation(ProfessionalDTO professionalDTO) {
        return new ProfessionalRepresentation(professionalDTO.getName(), professionalDTO.getProfession());
    }

    @Override
    public ProfessionalDTO entityToDTO(Professional e) {
        var dto = new ProfessionalDTO();
        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setProfession(e.getProfession());
        return dto;
    }

    @Override
    public Professional dtoToEntity(ProfessionalDTO professionalDTO) {
        var entity = new Professional(
                professionalDTO.getId(), professionalDTO.getName(), professionalDTO.getProfession());
        return null;
    }
}
