import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

class Theater {
    private String name;
    private Map<Integer, Auditorium> auditoriums;

    public Theater(String name) {
        this.name = name;
        this.auditoriums = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addAuditorium(Auditorium auditorium) {
        auditoriums.put(auditorium.getId(), auditorium);
    }

    public Auditorium getAuditorium(int id) {
        return auditoriums.get(id);
    }

    public List<Auditorium> getAuditoriums() {
        return new ArrayList<>(auditoriums.values());
    }
}

class Auditorium {
    private int id;
    private int rows;
    private int seatsPerRow;
    private Seat[][] seats;

    public Auditorium(int id, int rows, int seatsPerRow) {
        this.id = id;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.seats = new Seat[rows][seatsPerRow];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                seats[i][j] = new Seat(i + 1, j + 1);
            }
        }
    }

    public int getId() {
        return id;
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public void displaySeats() {
        System.out.println("Расположение мест:");
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                System.out.print(seat.isBooked() ? "[X] " : "[O] ");
            }
            System.out.println();
        }
    }
}

class Seat {
    private int row;
    private int number;
    private boolean booked;

    public Seat(int row, int number) {
        this.row = row;
        this.number = number;
        this.booked = false;
    }

    public boolean isBooked() {
        return booked;
    }

    public void book() {
        this.booked = true;
    }

    public String toString() {
        return "Ряд: " + row + ", Место: " + number;
    }
}

class Film {
    private String title;
    private int duration;

    public Film(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
}

class Screening {
    private Film film;
    private Theater theater;
    private Auditorium auditorium;
    private Date time;

    public Screening(Film film, Theater theater, Auditorium auditorium, Date time) {
        this.film = film;
        this.theater = theater;
        this.auditorium = auditorium;
        this.time = time;
    }

    public Film getFilm() {
        return film;
    }

    public Theater getTheater() {
        return theater;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public Date getTime() {
        return time;
    }

    public boolean hasAvailableSeats() {
        for (Seat[] row : auditorium.getSeats()) {
            for (Seat seat : row) {
                if (!seat.isBooked()) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class Cinema {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, User> users = new HashMap<>();
    private static final List<Theater> theaters = new ArrayList<>();
    private static final List<Film> films = new ArrayList<>();
    private static final List<Screening> screenings = new ArrayList<>();

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm");

    static {
        users.put("admin", new User("admin", "admin"));
        users.put("user", new User("user", "user"));
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Добро пожаловать в систему кинотеатров ===");
            System.out.println("1. Войти как администратор\n2. Войти как пользователь\n3. Выход");
            int choice = readIntInput("Выберите действие: ");
            if (choice == 1) {
                adminLogin();
            } else if (choice == 2) {
                userLogin();
            } else if (choice == 3) {
                System.out.println("До свидания!");
                break;
            }
        }
    }

    private static void adminLogin() {
        System.out.println("=== Авторизация администратора ===");
        String login = readStringInput("Введите логин: ");
        String password = readStringInput("Введите пароль: ");
        if (authenticateAdmin(login, password)) {
            adminMenu();
        } else {
            System.out.println("Неверный логин или пароль.");
        }
    }

    private static void userLogin() {
        System.out.println("=== Авторизация пользователя ===");
        String login = readStringInput("Введите логин: ");
        String password = readStringInput("Введите пароль: ");
        if (authenticateUser(login, password)) {
            userMenu();
        } else {
            System.out.println("Неверный логин или пароль.");
        }
    }

    private static boolean authenticateAdmin(String login, String password) {
        return users.containsKey(login) && users.get(login).getPassword().equals(password) && login.equals("admin");
    }

    private static boolean authenticateUser(String login, String password) {
        return users.containsKey(login) && users.get(login).getPassword().equals(password);
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("=== Меню администратора ===");
            System.out.println("1. Добавить кинотеатр\n2. Добавить зал\n3. Добавить фильм\n4. Создать сеанс\n5. Назад");
            int choice = readIntInput("Выберите действие: ");
            switch (choice) {
                case 1:
                    addTheater();
                    break;
                case 2:
                    addAuditorium();
                    break;
                case 3:
                    addFilm();
                    break;
                case 4:
                    createScreening();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Некорректный выбор.");
            }
        }
    }

    private static void userMenu() {
        while (true) {
            System.out.println("=== Меню пользователя ===");
            System.out.println("1. Найти ближайший сеанс фильма\n2. Купить билет\n3. Просмотреть расписание\n4. Назад");
            int choice = readIntInput("Выберите действие: ");
            switch (choice) {
                case 1:
                    findNearestScreening();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    viewSchedule();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Некорректный выбор.");
            }
        }
    }

    private static void addTheater() {
        String name = readStringInput("Введите название кинотеатра: ");
        theaters.add(new Theater(name));
        System.out.println("Кинотеатр успешно добавлен.");
    }

    private static void addAuditorium() {
        if (theaters.isEmpty()) {
            System.out.println("Сначала добавьте хотя бы один кинотеатр.");
            return;
        }
        System.out.println("Выберите кинотеатр:");
        for (int i = 0; i < theaters.size(); i++) {
            System.out.println((i + 1) + ". " + theaters.get(i).getName());
        }
        int index = readIntInput("Введите номер: ") - 1;
        if (index < 0 || index >= theaters.size()) {
            System.out.println("Некорректный выбор.");
            return;
        }
        Theater theater = theaters.get(index);
        int rows = readIntInput("Введите количество рядов: ");
        int seatsPerRow = readIntInput("Введите количество мест в ряду: ");
        theater.addAuditorium(new Auditorium(theater.getAuditoriums().size() + 1, rows, seatsPerRow));
        System.out.println("Зал успешно добавлен.");
    }

    private static void addFilm() {
        String title = readStringInput("Введите название фильма: ");
        int duration = readIntInput("Введите длительность (в минутах): ");
        films.add(new Film(title, duration));
        System.out.println("Фильм успешно добавлен.");
    }

    private static void createScreening() {
        if (films.isEmpty() || theaters.isEmpty()) {
            System.out.println("Добавьте хотя бы один фильм и кинотеатр.");
            return;
        }
        System.out.println("Выберите фильм:");
        for (int i = 0; i < films.size(); i++) {
            System.out.println((i + 1) + ". " + films.get(i).getTitle());
        }
        int filmIndex = readIntInput("Введите номер: ") - 1;
        if (filmIndex < 0 || filmIndex >= films.size()) {
            System.out.println("Некорректный выбор.");
            return;
        }
        Film film = films.get(filmIndex);

        System.out.println("Выберите кинотеатр:");
        for (int i = 0; i < theaters.size(); i++) {
            System.out.println((i + 1) + ". " + theaters.get(i).getName());
        }
        int theaterIndex = readIntInput("Введите номер: ") - 1;
        if (theaterIndex < 0 || theaterIndex >= theaters.size()) {
            System.out.println("Некорректный выбор.");
            return;
        }
        Theater theater = theaters.get(theaterIndex);

        System.out.println("Выберите зал:");
        List<Auditorium> auditoriums = theater.getAuditoriums();
        for (int i = 0; i < auditoriums.size(); i++) {
            System.out.println((i + 1) + ". Зал " + auditoriums.get(i).getId());
        }
        int auditoriumIndex = readIntInput("Введите номер: ") - 1;
        if (auditoriumIndex < 0 || auditoriumIndex >= auditoriums.size()) {
            System.out.println("Некорректный выбор.");
            return;
        }
        Auditorium auditorium = auditoriums.get(auditoriumIndex);

        String timeInput = readStringInput("Введите дату и время сеанса (дд.ММ.гггг ЧЧ:мм): ");
        try {
            Date time = DATE_FORMAT.parse(timeInput);
            screenings.add(new Screening(film, theater, auditorium, time));
            System.out.println("Сеанс успешно создан.");
        } catch (ParseException e) {
            System.out.println("Некорректный формат даты.");
        }
    }

    private static void findNearestScreening() {
        if (screenings.isEmpty()) {
            System.out.println("Нет доступных сеансов.");
            return;
        }
        String title = readStringInput("Введите название фильма: ");
        Date now = new Date();
        Screening nearest = null;
        for (Screening screening : screenings) {
            if (screening.getFilm().getTitle().equalsIgnoreCase(title) && screening.getTime().after(now) && screening.hasAvailableSeats()) {
                if (nearest == null || screening.getTime().before(nearest.getTime())) {
                    nearest = screening;
                }
            }
        }
        if (nearest != null) {
            System.out.println("Ближайший сеанс:");
            System.out.println("Фильм: " + nearest.getFilm().getTitle());
            System.out.println("Кинотеатр: " + nearest.getTheater().getName());
            System.out.println("Зал: " + nearest.getAuditorium().getId());
            System.out.println("Время: " + DATE_FORMAT.format(nearest.getTime()));
        } else {
            System.out.println("Нет доступных сеансов для этого фильма.");
        }
    }

    private static void buyTicket() {
        if (screenings.isEmpty()) {
            System.out.println("Нет доступных сеансов.");
            return;
        }
        System.out.println("Доступные сеансы:");
        for (int i = 0; i < screenings.size(); i++) {
            Screening screening = screenings.get(i);
            System.out.println((i + 1) + ". Фильм: " + screening.getFilm().getTitle() +
                    ", Кинотеатр: " + screening.getTheater().getName() +
                    ", Зал: " + screening.getAuditorium().getId() +
                    ", Время: " + DATE_FORMAT.format(screening.getTime()));
        }
        int screeningIndex = readIntInput("Выберите сеанс: ") - 1;
        if (screeningIndex < 0 || screeningIndex >= screenings.size()) {
            System.out.println("Некорректный выбор.");
            return;
        }
        Screening screening = screenings.get(screeningIndex);
        if (!screening.hasAvailableSeats()) {
            System.out.println("Нет свободных мест.");
            return;
        }
        screening.getAuditorium().displaySeats();
        int row = readIntInput("Введите номер ряда: ");
        int seatNumber = readIntInput("Введите номер места: ");
        Seat[][] seats = screening.getAuditorium().getSeats();
        if (row < 1 || row > seats.length || seatNumber < 1 || seatNumber > seats[0].length) {
            System.out.println("Некорректный выбор места.");
            return;
        }
        Seat seat = seats[row - 1][seatNumber - 1];
        if (seat.isBooked()) {
            System.out.println("Место уже занято.");
        } else {
            seat.book();
            System.out.println("Билет успешно куплен: " + seat);
        }
    }

    private static void viewSchedule() {
        if (screenings.isEmpty()) {
            System.out.println("Нет доступных сеансов.");
            return;
        }
        System.out.println("Расписание сеансов:");
        for (Screening screening : screenings) {
            System.out.println("Фильм: " + screening.getFilm().getTitle() +
                    ", Кинотеатр: " + screening.getTheater().getName() +
                    ", Зал: " + screening.getAuditorium().getId() +
                    ", Время: " + DATE_FORMAT.format(screening.getTime()));
        }
    }

    private static int readIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Введите число.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static String readStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    static class User {
        private String login;
        private String password;

        public User(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }
}