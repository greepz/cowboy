package app.repository.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Ride {

    public enum Level {
        Low, Middle, Hard
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ride_id", referencedColumnName = "id")
    private List<Photo> photos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ride_id", referencedColumnName = "id")
    private List<Video> videos;

    private double amount;

    private LocalDateTime start;

    private LocalDateTime end;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ride_id", referencedColumnName = "id")
    private Stable stable;

    //private User user;        пользователь, который создал мероприятие

    private String description;

    private Level level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Stable getStable() {
        return stable;
    }

    public void setStable(Stable stable) {
        this.stable = stable;
    }

    // public User getUser() { return user; }

    // public void setUser(User user) {this.user = user; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
