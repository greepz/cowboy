package app.services.composite;

import app.model.dto.PortfolioDto;
import app.services.PhotoService;
import app.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {
    @Autowired
    private PhotoService photoService;
    @Autowired
    private VideoService videoService;

    public PortfolioDto getPortfolioByStableId(Long id){
        PortfolioDto dto = new PortfolioDto();
        dto.setPhotos(photoService.findByStableId(id));
    }

    public

}
