package app.services;

import app.model.converters.DataConverter;
import app.model.dto.PhotoDto;
import app.model.dto.PortfolioDto;
import app.repository.PhotoRepository;
import app.repository.StableRepository;
import app.repository.entity.Photo;
import app.repository.entity.Stable;
import app.repository.entity.Video;
import app.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PortfolioService {
    private final Logger LOGGER = Logger.getLogger(PortfolioService.class.getName());

    @Autowired
    StableRepository repository;

    @Autowired
    @Qualifier("portfolioConverter")
    private DataConverter<Stable, PortfolioDto> converter;

    @Autowired
    @Qualifier("photoConverter")
    private DataConverter<Photo, PhotoDto> photoConverter;


    public PortfolioDto getPortfolio(Long id){
        PortfolioDto portfolio = null;
        try{
            LOGGER.log(Level.INFO, "Получение портфолио конюшни по id");
            Stable stable = repository.getOne(id);
            portfolio = converter.toModel(stable);
            LOGGER.log(Level.INFO, "Портфолио конюшни получено");
        }catch (Exception e) {
            LOGGER.log(Level.INFO, "Ошибка получения портфолио: {0}", e.getMessage());
        }

        return portfolio;
    }

    public List<PhotoDto> savePhotos(List<Photo> photos, Long id){
        List<Photo> photoList = null;
        try{
            LOGGER.log(Level.INFO, "Получение конюшни по id");
            Stable stable = repository.getOne(id);
            stable.setPhotos(photos);
            LOGGER.log(Level.INFO, "Сохранение списка фотографий {0}", Utils.toString(photos));
            photoList = repository.save(stable).getPhotos();
            LOGGER.log(Level.INFO, "Список фотографий сохранен");
        }catch (Exception e){
            LOGGER.log(Level.SEVERE, "Ошибка сохранения фотографий: {0}", e.getMessage());
        }

        return convertToPhotoDto(photoList);
    }

    private List<PhotoDto> convertToPhotoDto(List<Photo> photoList) {
        List<PhotoDto> dtos = new LinkedList<>();
        for (Photo photo : photoList){
            dtos.add(photoConverter.toModel(photo));
        }
        return dtos;
    }

    public void saveVideos(List<Video> videos, Long id){
        try{
            LOGGER.log(Level.INFO, "Получение конюшни по id");
            Stable stable = repository.getOne(id);
            stable.setVideos(videos);
            LOGGER.log(Level.INFO, "Сохранение списка ссылок на видео {0}", Utils.toString(videos));
            repository.save(stable);
            LOGGER.log(Level.INFO, "Список видео ссылок сохранен");
        }catch (Exception e){
            LOGGER.log(Level.INFO, "Ошибка сохранения видео ссылок: {0}", e.getMessage());
        }
    }


}
