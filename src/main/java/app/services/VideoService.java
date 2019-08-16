package app.services;

import app.model.converters.DataConverter;
import app.model.dto.PhotoDto;
import app.repository.PhotoRepository;
import app.repository.VideoRepository;
import app.repository.entity.Photo;
import app.repository.entity.Video;
import app.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class VideoService {
    private final Logger LOGGER = Logger.getLogger(VideoService.class.getName());
    @Autowired
    private VideoRepository repository;


    public List<Video> findAll(){
        List<Video> videos = null;
        try{
            videos = repository.findAll();
            LOGGER.log(Level.INFO, "Сервис VideoRepository успешно отработал. Метод findAll: {0} "+ Utils.toString(videos));
        }catch (Exception ex){
            LOGGER.log(Level.SEVERE, "Ошибка получения списка ссылок на видео {0}", ex.getMessage());
        }

       return videos;
    }

    public void save(Video video){
        repository.save(video);
    }

}
