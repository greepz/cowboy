package app.model.converters;

import app.model.dto.VideoDto;
import app.repository.entity.Video;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("videoConverter")
public class VideoConverter implements DataConverter<Video, VideoDto> {
    @Override
    public VideoDto toModel(Video entity) {
        return  new VideoDto(entity.getName(), entity.getUrl(), entity.getId());
    }
}
