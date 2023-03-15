public class var3_ex9 {
    public static void main(String[] args) {
        Photo photo1 = new Photo("Beach");
        Photo photo2 = new Photo("Mountains");
        Photo photo3 = new Photo();

        photo3.setName("Mountains");

        System.out.println("Photos 2 and 3 are equal: " + photo2.equals(photo3));

        System.out.println("Hash code for photo 1: " + photo1.hashCode());

        System.out.println("Photo 2 = " + photo2);

        PhotoAlbum album1 = new PhotoAlbum("Vacation");
        album1.addPhoto(photo1);
        album1.addPhoto(photo2);

        PhotoAlbum album2 = new PhotoAlbum("Office");
        album2.addPhoto(photo3);

        System.out.println("Albums are equal: " + album1.equals(album2));

        System.out.println("Hash code for album 2: " + album2.hashCode());

        System.out.println("Album 1 = " + album1);

        System.out.println("Number of photos in album 1: " + album1.getNumberOfPhotos());
    }
}
