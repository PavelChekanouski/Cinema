package view;

import controller.command.CommandNames;

import java.sql.Date;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleReader {
    private final Scanner scanner = new Scanner(System.in);

    public String readClient() {
        System.out.println(Arrays.toString(Arrays.stream(CommandNames.values()).filter(a -> a != CommandNames.WrongRequest).toArray()));
        System.out.println("FindByDirectorId - Find all films by director's id.");
        System.out.println("FindByDate - Find all films released later than certain date.");
        System.out.println("FindByDirectorIdAndDate - Find all films released later than certain date and made by needed director.");
        System.out.print("Enter command: ");
        return scanner.nextLine();
    }

    public String readURL(){
        System.out.println("Please, enter URL of your Database. Example: jdbc:postgresql://127.0.0.1:[Port:5432 default]/Cinema");
        return scanner.nextLine();
    }

    public String readUsername(){
        System.out.println("Please, enter Username, default username is postgres.");
        return scanner.nextLine();
    }

    public String readPassword(){
        System.out.println("Please, enter password.");
        return scanner.nextLine();
    }
    public String readDirector_id(){
        System.out.println("Please, enter director's id.");
        return scanner.nextLine();
    }
    public String readRelease_date(){
        System.out.println("Please, enter date of film's release in format: YYYY-MM-DD.");
        return scanner.nextLine();
    }
}
