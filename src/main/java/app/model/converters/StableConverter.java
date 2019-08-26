package app.model.converters;

import app.model.dto.StableDto;
import app.repository.entity.Stable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Qualifier("stableConverter")
public class StableConverter implements DataConverter<Stable, StableDto> {

    private static final String DELIMETER = ", ";

    @Override
    public StableDto toModel(Stable entity) {
        StableDto stableDto = new StableDto();
        stableDto.setId(entity.getId());
        stableDto.setAddress(entity.getAddress());
        stableDto.setName(entity.getName());
        stableDto.setDescription(entity.getDescription());
        stableDto.setUrl(entity.getUrl());
        StringBuilder str = new StringBuilder();

        if (entity.getAddress().getCountry() != null && !entity.getAddress().getCountry().isEmpty())
            str.append(entity.getAddress().getCountry());

        if (entity.getAddress().getRegion() != null && !entity.getAddress().getRegion().isEmpty())
            str.append(DELIMETER+entity.getAddress().getRegion());

        if (entity.getAddress().getDistrict() != null && !entity.getAddress().getDistrict().isEmpty())
            str.append(DELIMETER+entity.getAddress().getDistrict());

        if (entity.getAddress().getCity() != null && !entity.getAddress().getCity().isEmpty())
            str.append(DELIMETER+entity.getAddress().getCity());

        if (entity.getAddress().getLocality() != null && !entity.getAddress().getLocality().isEmpty())
            str.append(DELIMETER+entity.getAddress().getLocality());

        if (entity.getAddress().getStreet() != null && !entity.getAddress().getStreet().isEmpty())
            str.append(DELIMETER+"ул. "+entity.getAddress().getStreet());

        if (entity.getAddress().getHouse() != null && !entity.getAddress().getHouse().isEmpty())
            str.append(DELIMETER+"д. "+entity.getAddress().getHouse());

        if (entity.getAddress().getBuilding() != null && !entity.getAddress().getBuilding().isEmpty())
            str.append(DELIMETER+"стр. "+entity.getAddress().getBuilding());

        if (entity.getAddress().getHousing() != null && !entity.getAddress().getHousing().isEmpty())
            str.append(DELIMETER+"корп. "+entity.getAddress().getHousing());

        stableDto.setFullAddress(str.toString());
        return stableDto;
    }
}
