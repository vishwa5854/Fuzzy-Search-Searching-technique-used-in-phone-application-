package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        new Contacts();
        Contacts[] contacts = new Contacts[countNumberOfLinesInAFile()];
        try {
            setContactsIntoList(contacts);
        } catch (IOException e) {
            System.out.println("Failed to load contacts");
        }
        assignNumericalValuesToContacts(contacts);
        while (true) {
            System.out.print("Enter the input:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            showSuggestions(contacts, input);
        }

    }

    private static void showSuggestions(Contacts[] contacts, String input) throws IOException {
        String[] finalArray = assignTheLengthValueToNewArray(input,contacts);
        for(int i=0;i<countNumberOfLinesInAFile();i++){
            try {
                if (input.compareTo(String.valueOf(contacts[i].numericalName)) == 0) {
                    System.out.println(contacts[i].actualName);
                } else if ((finalArray[i].compareTo(input)) == 0) {
                    System.out.println(contacts[i].actualName);
                }
                else if(input.compareTo(contacts[i].actualName) == 0){
                    System.out.println(contacts[i].actualName + "\n" + contacts[i].numericalName);
                }
            }catch (NullPointerException ignored){}
        }
    }

    private static void assignNumericalValuesToContacts(Contacts[] contacts) {
        for (Contacts contact : contacts) {
            for (int j = 0; j < contact.actualName.length(); j++) {
                if(contact.actualName.charAt(j) == ' '){
                    continue;
                }
                else if ((contact.actualName.charAt(j) == 'a' || contact.actualName.charAt(j) == 'A') || (contact.actualName.charAt(j) == 'b' || contact.actualName.charAt(j) == 'B') || (contact.actualName.charAt(j) == 'c' || contact.actualName.charAt(j) == 'C')) {
                    contact.numericalName.append("2");
                } else if ((contact.actualName.charAt(j) == 'd' || contact.actualName.charAt(j) == 'D') || (contact.actualName.charAt(j) == 'e' || contact.actualName.charAt(j) == 'E') || (contact.actualName.charAt(j) == 'f' || contact.actualName.charAt(j) == 'F')) {
                    contact.numericalName.append("3");
                } else if ((contact.actualName.charAt(j) == 'g' || contact.actualName.charAt(j) == 'G') || (contact.actualName.charAt(j) == 'h' || contact.actualName.charAt(j) == 'H') || (contact.actualName.charAt(j) == 'i' || contact.actualName.charAt(j) == 'I')) {
                    contact.numericalName.append("4");
                } else if ((contact.actualName.charAt(j) == 'j' || contact.actualName.charAt(j) == 'J') || (contact.actualName.charAt(j) == 'k' || contact.actualName.charAt(j) == 'K') || (contact.actualName.charAt(j) == 'l' || contact.actualName.charAt(j) == 'L')) {
                    contact.numericalName.append("5");
                } else if ((contact.actualName.charAt(j) == 'm' || contact.actualName.charAt(j) == 'M') || (contact.actualName.charAt(j) == 'n' || contact.actualName.charAt(j) == 'N') || (contact.actualName.charAt(j) == 'o' || contact.actualName.charAt(j) == 'O')) {
                    contact.numericalName.append("6");
                } else if ((contact.actualName.charAt(j) == 'p' || contact.actualName.charAt(j) == 'P') || (contact.actualName.charAt(j) == 'q' || contact.actualName.charAt(j) == 'Q') || (contact.actualName.charAt(j) == 'r' || contact.actualName.charAt(j) == 'R') || (contact.actualName.charAt(j) == 's' || contact.actualName.charAt(j) == 'S')) {
                    contact.numericalName.append("7");
                } else if ((contact.actualName.charAt(j) == 't' || contact.actualName.charAt(j) == 'T') || (contact.actualName.charAt(j) == 'u' || contact.actualName.charAt(j) == 'U') || (contact.actualName.charAt(j) == 'v' || contact.actualName.charAt(j) == 'V')) {
                    contact.numericalName.append("8");
                } else if ((contact.actualName.charAt(j) == 'w' || contact.actualName.charAt(j) == 'W') || (contact.actualName.charAt(j) == 'x' || contact.actualName.charAt(j) == 'X') || (contact.actualName.charAt(j) == 'y' || contact.actualName.charAt(j) == 'Y') || (contact.actualName.charAt(j) == 'z' || contact.actualName.charAt(j) == 'Z')) {
                    contact.numericalName.append("9");
                }
            }
            //System.out.println(contact.actualName);
            //System.out.println(contact.numericalName);
        }
    }

    private static String[] assignTheLengthValueToNewArray(String temp,Contacts[] contacts) throws IOException {
        String[] temp1 = new String[countNumberOfLinesInAFile()];
        for (int i = 0; i < countNumberOfLinesInAFile();i++) {
            if(contacts[i].numericalName.length() >= temp.length()) {
                temp1[i] = contacts[i].numericalName.substring(0, temp.length());
            }
        }
        return temp1;
    }

    private static void setContactsIntoList(Contacts[] con) throws IOException {
        FileReader fileReader = new FileReader("D:\\Test\\Contacts.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        for(int i=0;i<countNumberOfLinesInAFile();i++){
            con[i] = new Contacts(bufferedReader.readLine());
        }
    }

    private static int countNumberOfLinesInAFile() throws IOException {
        int count = 0;
        FileReader fileReader = new FileReader("D:\\Test\\Contacts.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.readLine()!=null){
            count++;
        }
        return count;
    }
}
