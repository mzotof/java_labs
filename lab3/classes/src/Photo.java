import java.util.Objects;

public class Photo {
    private String name;

    public Photo(String name) {
        this.name = name;
    }

    public Photo() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.equals(name, photo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "name='" + name + '\'' +
                '}';
    }
}
