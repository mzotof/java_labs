// Интерфейс Furniture
interface Furniture {
    void move();
    void disassemble();
}

// Абстрактный класс Closet, который реализует интерфейс Furniture
abstract class Closet implements Furniture {
    protected int height;
    protected int width;
    protected int depth;
    protected String material;

    public Closet(int height, int width, int depth, String material) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.material = material;
    }

    public void move() {
        System.out.println("Перемещаем шкаф");
    }

    public abstract void assemble();

    public void disassemble() {
        System.out.println("Разбираем шкаф");
    }
}

// Класс BookCloset, который наследует абстрактный класс Closet
class BookCloset extends Closet {
    private final int shelvesCount;

    public BookCloset(int height, int width, int depth, String material, int shelvesCount) {
        super(height, width, depth, material);
        this.shelvesCount = shelvesCount;
    }

    public void assemble() {
        System.out.println("Собираем книжный шкаф");
    }

    public void storeBooks() {
        System.out.println("Книги хранятся на " + shelvesCount + " полках");
    }
}

public class var2_ex9 {
    public static void main(String[] args) {
        BookCloset bookCloset = new BookCloset(200, 80, 40, "дерево", 4);
        bookCloset.move();
        bookCloset.assemble();
        bookCloset.storeBooks();
        bookCloset.disassemble();
    }
}
