package app.model.converters;

import app.model.dto.PhotoDto;
import app.repository.entity.Photo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
@Qualifier("photoConverter")
public class PhotoConverter implements DataConverter<Photo, PhotoDto> {
    @Override
    public PhotoDto toModel(Photo entity) {
        return new PhotoDto(entity.getName(), entity.getType(), Base64.getEncoder().encodeToString(entity.getFile()));
    }
}
