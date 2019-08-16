package app.controllers.portfolio;

import app.model.dto.PhotoDto;
import app.repository.entity.Photo;
import app.services.PhotoService;
import app.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;
import java.util.List;

@Controller
public class PortfolioController {



//    @GetMapping("/stable/")
//    public String view(Model model){
//        List<PhotoDto> photos = photoService.findAll();
//        if (photos != null && !photos.isEmpty()){
//            int cols = 5;
//            int rows =  (photos.size() % 5 == 0) ? photos.size()/cols : photos.size()/cols + 1;
//
//            model.addAttribute("rows", rows);
//            model.addAttribute("photos", photos);
//        }
//        return "index";
//    }
//
//    @PostMapping("/upload")
//    public String uploadImages(MultipartHttpServletRequest request){
//
//        try{
//            Iterator<String> itr = request.getFileNames();
//            while (itr.hasNext()){
//                String uplloadedFile = itr.next();
//                MultipartFile multipartFile = request.getFile(uplloadedFile);
//                String type = multipartFile.getContentType();
//                String name = multipartFile.getOriginalFilename();
//                byte[] file = multipartFile.getBytes();
//
//                Photo photo = new Photo(name, file, type);
//
//                service.save(photo);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return "index";
//    }
}
