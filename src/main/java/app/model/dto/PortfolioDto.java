package app.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PortfolioDto {
    private List<PhotoDto> photos;
    private List<VideoDto> videos;

    public PortfolioDto(List<PhotoDto> photos, List<VideoDto> videos) {
        this.photos = photos;
        this.videos = videos;
    }

    public PortfolioDto() {

    }

    public List<PhotoDto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoDto> photos) {
        this.photos = photos;
    }

    public List<VideoDto> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoDto> videos) {
        this.videos = videos;
    }
}
