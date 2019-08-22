package app.controllers.portfolio;

import app.model.dto.PhotoDto;
import app.repository.entity.Photo;
import app.services.PortfolioService;
import app.services.StableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class PortfolioController {

    private final static Logger LOGGER = Logger.getLogger(PortfolioController.class.getName());

    @Autowired
    PortfolioService service;



    @GetMapping("/stable/{id}/portfolio")
    public String getPortfolio(@PathVariable(name = "id") Long id, Model model){
        LOGGER.log(Level.INFO, "Вызов сервиса PortfolioService");
        model.addAttribute("portfolio", service.getPortfolio(id));
        model.addAttribute("stableId", id);
        return "/portfolio/index";
    }

    @PostMapping("/stable/{id}/portfolio/save")
    @ResponseBody
    public List<PhotoDto> addPortfolioImages(MultipartHttpServletRequest request, @PathVariable(name = "id") Long id){
        List<PhotoDto> photoDtos = new LinkedList<>();
        try{
            Iterator<String> itr = request.getFileNames();
            List<Photo> photos = new LinkedList<>();
            while (itr.hasNext()){
                String uplloadedFile = itr.next();
                MultipartFile multipartFile = request.getFile(uplloadedFile);
                String type = multipartFile.getContentType();
                String name = multipartFile.getOriginalFilename();
                byte[] file = multipartFile.getBytes();
                Photo photo = new Photo(name, file, type);
                photos.add(photo);
            }
            LOGGER.log(Level.INFO, "Попытка вызова сервиса PortfolioService");
            photoDtos = service.savePhotos(photos, id);
            LOGGER.log(Level.INFO, "Сервис PortfolioService удачно отработал");
        }catch (Exception e){
            LOGGER.log(Level.SEVERE, "Ошибка вызова сервиса добавления фотографий");
        }
        return photoDtos;
    }

}
