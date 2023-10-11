package Repository;
import DataAccess.WorkerDao;

public class WorkerRepository implements IWorkerRepository {
    private final WorkerDao data = new WorkerDao();

    @Override
    public void addNewWorker() {
        data.addWorker();
    }

    public void SalaryUp() {
        data.upSalary();
    }

    @Override
    public void SalaryDown() {
        data.downSalary();
    }

    @Override
    public void printHistory() {
        data.printListHistory();
    }

}
