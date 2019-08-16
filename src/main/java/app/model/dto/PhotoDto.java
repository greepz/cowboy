package app.model.dto;

public class PhotoDto {
    private String name;
    private String type;
    private String file;

    public PhotoDto(String name, String type, String file) {
        this.name = name;
        this.type = type;
        this.file = file;
    }

    public PhotoDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
