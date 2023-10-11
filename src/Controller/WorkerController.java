package Controller;
import Repository.WorkerRepository;
import View.Menu;

public class WorkerController extends Menu {
    private final WorkerRepository WorkerRepository;
    static String[] options = {"Add Worker", "Up salary", "Down salary", "Display Information salary", "Exit"};


    public WorkerController() {
        super("====== WORKER MANAGEMENT SYSTEM ======", options);
        WorkerRepository = new WorkerRepository();
    }
    public void execute(int choice) {
        switch(choice){
            case 1:
                WorkerRepository.addNewWorker();
                break;
            case 2:
                WorkerRepository.SalaryUp();
                break;
            case 3:
                WorkerRepository.SalaryDown();
                break;
            case 4:
                WorkerRepository.printHistory();
                break;
            case 5:
                System.out.println("Exit.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid!");
        }
    }
}
