import java.util.Scanner;

public class Agenda {
    static final int MAX = 5;
    static final int EXIT = 6;
    static Person[] users = new Person[5];

    public static void main(String[] args) throws NullPointerException {

        users[0] = new Person("user1", "09231231");
        users[1] = new Student("Mihai", "019231231", 2);
        users[2] = new Pensioner("user3", "parola123", 123153.213);

        Scanner input = new Scanner(System.in);
        int optiune;

        menu();
        System.out.print("Choose a menu option by typing the appropriate index: ");
        optiune = input.nextInt();

        while (optiune != EXIT) {
            System.out.println("You chose: " + optiune);

            switch (optiune) {

                case 1: display();break;
                case 2: search();break;
                case 3: add();break;
                case 4: modify();break;
                case 5: delete();break;
                default: System.out.println(optiune + " does not exist in the menu. Try typing the corresponding number of the option you want to access.");break;
            }

            menu();
            System.out.print("Choose a menu option by typing the appropriate index: ");
            optiune = input.nextInt();
        }

    }

    static void menu() {
        System.out.println("--------------------------------------------------");
        System.out.println("1. Display");
        System.out.println("2. Search");
        System.out.println("3. Add");
        System.out.println("4. Modify");
        System.out.println("5. Delete");
        System.out.println("6. EXIT");
    }

    static void display() {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                if (users[i] instanceof Person && !(users[i] instanceof Student) && !(users[i] instanceof Pensioner)) {
                    System.out.println(users[i].getName() + " " + users[i].getPhone() + " " );
                }
                if (users[i] instanceof Student) {
                    System.out.println(users[i].getName() + " " + users[i].getPhone() + " " + ((Student) users[i]).getYear());
                }
                if (users[i] instanceof Pensioner) {
                    System.out.println(users[i].getName() + " " + users[i].getPhone() + " " + ((Pensioner) users[i]).getPension());
                }
            }
        }
    }

        static void search() {
            Scanner input = new Scanner(System.in);
            System.out.print("Type the phone number or name that you want to find: ");
            String searchFor = input.nextLine().toLowerCase();
            boolean found = false;

            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    continue;
                } else if (users[i].getName().toLowerCase().contains(searchFor)) {
                    System.out.println("The contact name has been found at the index:: " + i + ". " + users[i].getName());
                    found = true;
                } else if (users[i].getPhone().contains(searchFor)) {
                    System.out.println("The phone number has been found at the index: " + i + ". " + users[i].getPhone());
                }
            }
            if (!found) {
                System.out.println("The name or phone number was not found on the agenda.");
            }
        }

        static void add () {
            Scanner input = new Scanner(System.in);
            System.out.print("What type of contact would you like to add? " +
                    "1.Person - " +
                    "2.Student - " +
                    "3.Pensioner: ");
            int nr = input.nextInt();
try {
    System.out.print("Type the name for the new contact: ");
    String name = input.next();
    System.out.print("Type the phone number for the new contact: ");
    String phone = input.next();

    int yearM=0;
    double pensionM=0;
    boolean full = false;
    for (int i = 0; i < users.length; i++) {
        if (users[i] == null) {
            switch (nr){
                case 1: users[i] = new Person(name, phone);break;
                case 2: users[i] = new Student(name, phone, yearM);break;
                case 3: users[i] = new Pensioner(name, phone, pensionM);break;
                default:
                    System.out.println("Index out of bounds.");break;
            }
            if (nr == 2 && users[i] instanceof Student) {
                System.out.print("Type the year of the student: ");
                yearM = input.nextInt();
                ((Student) users[i]).setYear(yearM);
            } else if (nr == 3 && users[i] instanceof Pensioner) {
                System.out.print("Type the pension of the pensioner: ");
                pensionM = input.nextDouble();
                ((Pensioner) users[i]).setPension(pensionM);
            }
            full = true;
            break;
        }
    }
    if (!full)
        System.out.println("I'm sorry, the agenda is already full..");
} catch (NullPointerException e) {
    System.out.println("There was an error. Retrying...");
    add();
}
        }

        static void modify () {
            Scanner input = new Scanner(System.in);
            System.out.print("Type the appropriate index of the name or phone number you want to modify. Or type '-1' to go back to the menu. ");
            int index = input.nextInt();

            if (index >= MAX) {
                System.out.println("You have exceeded the size of the string.");
                modify();
            } else if (index >= 0 && index < MAX) {
                System.out.print("Type the new name of the contact: ");
                String name = input.next();
                users[index].setName(name);
                System.out.print("Type the new phone number of the contact: ");
                String phone = input.next();
                users[index].setPhone(phone);
                if (users[index] instanceof Student) {
                    System.out.print("Type the new year of the student: ");
                    int yearM = input.nextInt();
                    ((Student) users[index]).setYear(yearM);
                } else if (users[index] instanceof Pensioner) {
                    System.out.print("Type the new pension of the student: ");
                    double pensionM = input.nextDouble();
                    ((Pensioner) users[index]).setPension(pensionM);
                }
                System.out.println("The contact has been modified.");
            } else if (index == -1) {
            }
        }

        static void delete() {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the appropriate index of the contact you want to delete. If you want to go back to the menu, type '-1'. ");
            int index = input.nextInt();


            if (index == -1) {

            } else if (users[index] == null) {
                System.out.println("Index value selected already has the value 'null'.");
            } else {
                users[index] = null;
            }
        }
    }



