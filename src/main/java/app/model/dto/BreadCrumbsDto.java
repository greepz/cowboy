package app.model.dto;

public class BreadCrumbsDto {
    private String name;
    private String url;

    public BreadCrumbsDto(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
