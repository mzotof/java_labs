import java.util.ArrayList;
import java.util.Objects;

public class PhotoAlbum {
    private String name;
    private final ArrayList<Photo> photos;

    public PhotoAlbum(String name) {
        this.name = name;
        this.photos = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPhoto(Photo photo) {
        photos.add(photo);
    }

    public int getNumberOfPhotos() {
        return photos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoAlbum that = (PhotoAlbum) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(photos, that.photos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, photos);
    }

    @Override
    public String toString() {
        return "PhotoAlbum{" +
                "name='" + name + '\'' +
                ", photos=" + photos +
                '}';
    }
}