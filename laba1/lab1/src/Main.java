import java.util.*;


public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        LinkedList<Library> libraryList = new LinkedList();
        LinkedList<Book> bookListFirst = new LinkedList();

        bookListFirst.add(new Book("Москвич", "412", 1953));
        bookListFirst.add(new Book("Рено", "Меган", 1950));
        bookListFirst.add(new Book("БМВ", "Х5", 1954));
        bookListFirst.add(new Book("Мерседес", "140", 1984));
        bookListFirst.add(new Book("Лада", "Веста", 1945));
        libraryList.add(new Library("СССР", bookListFirst));

        LinkedList<Book> bookListSecond = new LinkedList();
        bookListSecond.add(new Book("Фольксваген", "Гольф", 1946));
        bookListSecond.add(new Book("Опель", "Астра", 1950));
        bookListSecond.add(new Book("Роллс-Ройс", "Гост", 1951));
        bookListSecond.add(new Book("Бугатти", "Вейрон", 1934));
        bookListSecond.add(new Book("Ламба", "Авентадор", 1938));
        libraryList.add(new Library("Германия", bookListSecond));

        Scanner in = new Scanner(System.in);



        int k = 0;
        while(k==0) {


            int authorFind = 0;
            int bookFind = 0;
            System.out.print("1.Вывести все автомобили\n");
            System.out.print("2.Вывести все автомобили советского производства\n");
            System.out.print("3.Вывести всех водителей со стжаем больше 20 лет\n");
            System.out.print("4.Добавить автомобиль\n");
            System.out.print("5.Удалить автомобиль\n");
            System.out.print("6.Изменить автомобиль\n");
            System.out.print("7.Выход\n");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    Iterator var1 = libraryList.iterator();

                    while (var1.hasNext()) {
                        Library library = (Library) var1.next();
                        library.displayInfo();
                    }
                    break;
                case 2:
                    System.out.print("Введите марку и модель\n");
                    Scanner st1 = new Scanner(System.in);
                    String authorName = st1.nextLine();
                    Iterator var2 = libraryList.iterator();

                    while (var2.hasNext()) {
                        Library library = (Library) var2.next();
                        authorFind=library.displayAuthorInfo(authorName, authorFind);
                    }
                    if(authorFind==0)
                        System.out.print("Нет информации об этом автомобиле\n");
                    break;
                case 3:
                    System.out.print("Введите имя водителя\n");
                    Scanner st2 = new Scanner(System.in);
                    String bookName = st2.nextLine();
                    Iterator var3 = libraryList.iterator();

                    while (var3.hasNext()) {
                        Library library = (Library) var3.next();
                        bookFind = library.displayBookInfo(bookName, bookFind);
                    }
                    if(bookFind==0)
                        System.out.print("Нет информации об этой водителе\n");
                    break;
                case 4:
                    //System.out.print("Добавить в какую библиотеку?\n");
                    Scanner st3 = new Scanner(System.in);
                    int numberOfLibrary = in.nextInt();
                    System.out.print("Введите марку и модель автомобиля и его массу\n");
                    Scanner st4 = new Scanner(System.in);
                    String bookNameForAdd = st4.nextLine();
                    String authorNameForAdd = st4.nextLine();
                    int yearForAdd = st4.nextInt();

                    switch (numberOfLibrary){
                        case 0:
                            libraryList.remove(numberOfLibrary);
                            bookListFirst.add(new Book(bookNameForAdd,authorNameForAdd, yearForAdd));
                            libraryList.addFirst(new Library("СССР", bookListFirst));
                            break;
                        case 1:
                            libraryList.remove(numberOfLibrary);
                            bookListSecond.add(new Book(bookNameForAdd,authorNameForAdd, yearForAdd));
                            libraryList.addLast(new Library("Германия", bookListSecond));
                            break;
                        default:
                            System.out.println("Проверьте правильность данных");
                    }


                    break;
                case 5:
                    //.out.print("Удалить из какой библиотеки?\n");
                    Scanner st6 = new Scanner(System.in);
                    int numberOfLibrary2 = st6.nextInt();
                    System.out.print("Введите номер автомобиля\n");
                    Scanner st5 = new Scanner(System.in);
                    int bookId = st5.nextInt();
                    switch (numberOfLibrary2){
                        case 0:
                            libraryList.removeFirst();
                            bookListFirst.remove(bookId);
                            libraryList.addFirst(new Library("СССР", bookListFirst));
                            break;
                        case 1:
                            libraryList.removeLast();
                            bookListSecond.remove(bookId);
                            libraryList.addLast(new Library("Германия", bookListSecond));
                            break;
                        default:
                            System.out.println("Проверьте правильность данных");
                    }
                    break;
                case 6:
                	//System.out.print("Изменить из какой библиотеки?\n");
                    Scanner st7 = new Scanner(System.in);
                    int numberOfLibrary3 = st7.nextInt();
                    System.out.print("Введите марку и модель автомобиля и его массу\n");
                    Scanner st8 = new Scanner(System.in);
                    int bookId2 = st8.nextInt();
                    Scanner st9 = new Scanner(System.in);
                    String bookNameForAdd2 = st9.nextLine();
                    String authorNameForAdd2 = st9.nextLine();
                    int yearForAdd2 = st9.nextInt();
                    switch (numberOfLibrary3){
                        case 0:
                            libraryList.removeFirst();
                            bookListFirst.remove(bookId2);
                            bookListFirst.add(new Book(bookNameForAdd2,authorNameForAdd2, yearForAdd2));
                            libraryList.addFirst(new Library("СССР", bookListFirst));
                            break;
                        case 1:
                            libraryList.removeLast();
                            bookListSecond.remove(bookId2);
                            bookListSecond.add(new Book(bookNameForAdd2,authorNameForAdd2, yearForAdd2));
                            libraryList.addLast(new Library("Германия", bookListSecond));
                            break;
                        default:
                            System.out.println("Проверьте правильность данных");
                    }
                    break;
                case 7:
                    k++;
                    break;
                default:
                    System.out.println("Проверьте правильность данных");
            }
        }


    }
}


class Library {
    String name;
    LinkedList<Book> bookList = new LinkedList();

    Library(String name, LinkedList<Book> bookList) {
        this.name = name;
        this.bookList = bookList;
    }

    void displayInfo() {
        //System.out.printf("Название библиотеки: %s\n", this.name);
        Iterator var1 = this.bookList.iterator();

        while (var1.hasNext()) {
            Book bookList = (Book) var1.next();
            bookList.displayInfo();
        }
    }

    String Get(){
        return this.name;
    }

    int displayAuthorInfo(String authorName, int authorFind) {
        Iterator var4 = this.bookList.iterator();

        while (var4.hasNext()) {
            Book bookList = (Book) var4.next();
            authorFind=bookList.displayAuthorInfo(authorName,authorFind);
        }
        return authorFind;
    }
    int displayBookInfo(String bookName, int bookFind) {
        Iterator var6 = this.bookList.iterator();

        while (var6.hasNext()) {
            Book bookList = (Book) var6.next();
            bookFind=bookList.displayBookInfo(bookName, bookFind);
        }
        return bookFind;
    }
}

class Book {
    String name;
    String author;
    int yearOfWriting;

    Book(String name, String author, int yearOfWriting) {
        this.name = name;
        this.author = author;
        this.yearOfWriting = yearOfWriting;
    }

    void displayInfo() {
        System.out.printf("Марка: %s, Модель: %s, Масса: %d\n", this.name, this.author, this.yearOfWriting);
    }
    int displayAuthorInfo(String authorName,int authorFind) {
        if(authorName.equals(this.author)) {
            System.out.printf("Марка: %s, Модель: %s, Масса: %d\n", this.name, this.author, this.yearOfWriting);
            authorFind++;
        }
        return authorFind;
    }
    int displayBookInfo(String bookName, int bookFind) {
        if(bookName.equals(this.name)) {
            System.out.printf("Марка: %s, Модель: %s, Масса: %d\n", this.name, this.author, this.yearOfWriting);
            bookFind++;
        }
        return bookFind;
    }
}