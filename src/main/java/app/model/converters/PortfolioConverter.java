package app.model.converters;

import app.model.dto.PhotoDto;
import app.model.dto.PortfolioDto;
import app.model.dto.VideoDto;
import app.repository.entity.Photo;
import app.repository.entity.Stable;
import app.repository.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
@Component
@Qualifier("portfolioConverter")
public class PortfolioConverter implements DataConverter<Stable, PortfolioDto> {

    @Autowired
    @Qualifier("photoConverter")
    private DataConverter<Photo, PhotoDto> photoConverter;

    @Autowired
    @Qualifier("videoConverter")
    private DataConverter<Video, VideoDto> videoConverter;


    @Override
    public PortfolioDto toModel(Stable entity) {
        PortfolioDto portfolio = new PortfolioDto();
        if (!entity.getPhotos().isEmpty()){
            List<PhotoDto> photoList = new LinkedList<>();
            for (Photo photo : entity.getPhotos()){
                photoList.add(photoConverter.toModel(photo));
            }
            portfolio.setPhotos(photoList);
            portfolio.setStableName(entity.getName());
        }

        if (!entity.getVideos().isEmpty()){
            List<VideoDto> videoList = new LinkedList<>();
            for (Video video : entity.getVideos()){
                videoList.add(videoConverter.toModel(video));
            }
            portfolio.setVideos(videoList);
        }
        portfolio.setStableId(entity.getId());

        return portfolio;
    }
}
