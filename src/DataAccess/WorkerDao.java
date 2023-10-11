package DataAccess;

import Common.Validate;
import Model.Worker;
import java.util.*;
import Model.History;
import java.text.SimpleDateFormat;

public class WorkerDao {
    private static List<History> historyList;
    private static List<Worker> workersList;

    public WorkerDao() {
        workersList = new ArrayList<>();
        historyList = new ArrayList<>();
    }

    public void addWorker() {
            System.out.println("--------- Add Worker ----------");
            System.out.print("Enter code: ");
            String id = Validate.checkInputString();
            System.out.print("Enter name: ");
            String name = Validate.checkInputString();
            System.out.print("Enter age: ");
            int age = Validate.checkInputIntLimit(18, 50);
            System.out.print("Enter salary: ");
            int salary = Validate.checkInputSalary();
            System.out.print("Enter work location: ");
            String workLocation = Validate.checkInputString();
            if (!Validate.checkWorkerExist((ArrayList<Worker>) workersList, id, name, age, salary, workLocation)) {
                System.err.println("Duplicate.");
            } else {
                workersList.add(new Worker(id, name, age, salary, workLocation));
                History history = new History("ADD", getCurrentDate(), id, name, age, salary, workLocation);
                historyList.add(history);
                System.err.println("Add successfully.");
                System.out.println("\n");
            }
    }
    public void upSalary() {
        if (workersList.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.println("------- Up Salary --------");
        System.out.print("Enter code: ");
        String id = Validate.checkInputString();
        Worker worker = getWorkerByCode(id);
        if (worker == null) {
            System.err.println("Worker not exist.");
            return;
        }
            int salaryCurrent = worker.getSalary();
            int salaryUpdate;
                System.out.print("Enter salary: ");
                while (true) {
                    salaryUpdate = Validate.checkInputSalary();
                    if (salaryUpdate <= salaryCurrent) {
                        System.err.println("Must be greater than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                workersList.add(new History("UP", getCurrentDate(), worker.getId(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorkLocation()));
            worker.setSalary(salaryUpdate);
            System.err.println("Update successfully");

    }

    public void downSalary() {
        if (workersList.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.println("------- Down Salary --------");
        System.out.print("Enter code: ");
        String id = Validate.checkInputString();
        Worker worker = getWorkerByCode(id);
        if (worker == null) {
            System.err.println("Not exist worker.");
            return;
        }
            int salaryCurrent = worker.getSalary();
            int salaryUpdate;
                System.out.print("Enter salary: ");
                while (true) {
                    salaryUpdate = Validate.checkInputSalary();
                    if (salaryUpdate >= salaryCurrent) {
                        System.err.println("Must be smaller than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                workersList.add(new History("DOWN", getCurrentDate(), worker.getId(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorkLocation()));
            worker.setSalary(salaryUpdate);
            System.err.println("Update successfully");
    }


    public static Worker getWorkerByCode(String id) {
        for (Worker worker : workersList) {
            if (worker.getId().equalsIgnoreCase(id)) {
                return worker;
            }
        }
        return null;
    }

    public Date getCurrentDate() {
        return new Date();
    }

    public void printListHistory() {
        if (historyList.isEmpty()) {
            System.err.println("List is empty.");
            return;
        }
        System.out.println("--------------------Display Information Salary-----------------------");
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (History history : historyList) {
            String formattedDate = dateFormat.format(history.getDate());
            System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n",
                    history.getId(),
                    history.getName(),
                    history.getAge(),
                    history.getSalary(),
                    history.getStatus(),
                    formattedDate);
        }
    }
}

