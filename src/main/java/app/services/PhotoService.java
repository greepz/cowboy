package app.services;

import app.model.converters.DataConverter;
import app.model.dto.PhotoDto;
import app.repository.PhotoRepository;
import app.repository.entity.Photo;
import app.util.Utils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PhotoService {
    private final Logger LOGGER = Logger.getLogger(PhotoService.class.getName());
    @Autowired
    PhotoRepository repository;

    @Autowired
    DataConverter<Photo, PhotoDto> converter;

    public List<PhotoDto> findAll(){
        List<Photo> photos = null;
        try{
            photos = repository.findAll();
            LOGGER.log(Level.INFO, "Сервис PhotoRepository успешно отработал. Метод findAll: {0} "+ Utils.toString(photos));
        }catch (Exception ex){
            LOGGER.log(Level.SEVERE, "Ошибка получения списка фотографий {0}", ex.getMessage());
        }
        List<PhotoDto> dtos = new LinkedList<>();
        if (photos != null && !photos.isEmpty()){
            for (Photo photo: photos) {
                dtos.add(converter.toModel(photo));
            }
        }
       return dtos;
    }

    public void save(Photo photo){
        repository.save(photo);
    }

}
