package app.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PortfolioDto {
    private List<PhotoDto> photos;
    private List<VideoDto> videos;
    private Long stableId;
    private String stableName;

    public PortfolioDto(List<PhotoDto> photos, List<VideoDto> videos, Long stableId) {
        this.photos = photos;
        this.videos = videos;
        this.stableId = stableId;
    }

    public PortfolioDto(List<PhotoDto> photos, List<VideoDto> videos, Long stableId, String stableName) {
        this.photos = photos;
        this.videos = videos;
        this.stableId = stableId;
        this.stableName = stableName;
    }

    public PortfolioDto() {

    }

    public String getStableName() {
        return stableName;
    }

    public void setStableName(String stableName) {
        this.stableName = stableName;
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
