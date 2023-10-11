package Common;

import Model.Worker;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Validate {

    private final static Scanner in = new Scanner(System.in);

    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static boolean checkIdExist(ArrayList<Worker> workersList, String id) {
        for (Worker worker : workersList) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return true;
            }
        }
        return false;
    }

    public static int checkInputSalary() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < 0) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Salary must be greater than 0");
                System.out.print("Enter again: ");
            }
        }
    }

    public static boolean checkWorkerExist(ArrayList<Worker> workersList, String id,
                                           String name, int age, int salary, String workLocation) {
        for (Worker worker : workersList) {
            if (id.equalsIgnoreCase(worker.getId())
                    && name.equalsIgnoreCase(worker.getName())
                    && age == worker.getAge()
                    && salary == worker.getSalary()
                    && Objects.equals(workLocation, worker.getWorkLocation())) {
                return false;
            }
        }
        return true;
    }

}