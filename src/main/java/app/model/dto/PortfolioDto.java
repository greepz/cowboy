package app.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PortfolioDto {
    private List<PhotoDto> photos;
    private List<VideoDto> videos;
    private Long stableId;

    public PortfolioDto(List<PhotoDto> photos, List<VideoDto> videos, Long stableId) {
        this.photos = photos;
        this.videos = videos;
        this.stableId = stableId;
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

    public Long getStableId() {
        return stableId;
    }

    public void setStableId(Long stableId) {
        this.stableId = stableId;
    }
}
