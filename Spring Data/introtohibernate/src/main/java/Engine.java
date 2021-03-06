import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;

public class Engine implements Runnable {
    private final EntityManager entityManager;
    private final BufferedReader bf;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bf = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
//        changeCasing();
//        try {
//            containsEmployee();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        employeesWithSalaryOver50000();
//        employeesFromDepartment();
//        try {
//            addingNewAddressAndUpdatingEmployee();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        addressesWithEmployeeCount();
//        try {
//            getEmployeeWithProject();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        findLatest10Projects();
//        increaseSalaries();
//        try {
//            findEmployeesByFirstName();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        employeesMaximumSalaries();
        try {
            removeTowns();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeTowns() throws IOException {
        String town = bf.readLine();
        entityManager.getTransaction().begin();
        entityManager.createQuery("SELECT e FROM Employee e WHERE e.address.town.name=:name", Employee.class)
                .setParameter("name", town).getResultStream().forEach(e -> e.setAddress(null));
        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a WHERE a.town.name=:name", Address.class)
                .setParameter("name", town).getResultList();
        int count = addresses.size();
        addresses.forEach(a->a.setTown(null));
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Town t WHERE t.name=:name").setParameter("name",town).executeUpdate();
        entityManager.getTransaction().commit();
        if (count == 1) {
            System.out.printf("%d address in %s deleted",count,town);
        }else
            System.out.printf("%d addresses in %s deleted",count,town);

    }

    private void employeesMaximumSalaries() {
        entityManager.createQuery("SELECT e FROM Employee e WHERE e.salary = " +
                "(SELECT max(em.salary) FROM Employee em WHERE e.department=em.department) " +
                "GROUP BY e.department HAVING max(e.salary) NOT BETWEEN 30000 AND 70000", Employee.class).getResultStream()
                .forEach(d -> System.out.printf("%s %.2f%n", d.getDepartment().getName(), d.getSalary()));
    }

    private void findEmployeesByFirstName() throws IOException {
        String input = bf.readLine();
        entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.firstName LIKE concat(:name, '%')", Employee.class).setParameter("name", input)
                .getResultStream().forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n",
                e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary()));
    }

    private void increaseSalaries() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("UPDATE Employee e SET e.salary = e.salary * 1.12 " +
                "WHERE e.department.id IN(1, 2, 4, 11)").executeUpdate();
        entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.department.id IN(1, 2, 4, 11)", Employee.class)
                .getResultStream().forEach(e -> System.out.printf("%s %s ($%.2f)%n", e.getFirstName(),
                e.getLastName(), e.getSalary()));
        entityManager.getTransaction().commit();
    }

    private void findLatest10Projects() {
        entityManager.createQuery("SELECT p FROM Project p ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10).getResultStream().sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.printf("Project name: %s%n\tProject Description: %s%n\tProject Start Date: %s%n\tProject End Date: %s%n",
                        p.getName(), p.getDescription(), p.getStartDate(), p.getEndDate()));
    }

    private void getEmployeeWithProject() throws IOException {
        int id = Integer.parseInt(bf.readLine());
        Employee employee = entityManager.find(Employee.class, id);
        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());
        employee.getProjects().stream().sorted(Comparator.comparing(Project::getName))
                .forEach(project -> System.out.println("\t" + project.getName()));
    }

    private void addressesWithEmployeeCount() {
        entityManager.createQuery("SELECT a FROM Address a ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10).getResultStream()
                .forEach(a -> System.out.printf("%s, %s - %d employees%n",
                        a.getText(), a.getTown().getName(), a.getEmployees().size()));
    }

    private void addingNewAddressAndUpdatingEmployee() throws IOException {
        Address address = createAddress("Vitoshka 15");
        String lastName = bf.readLine();
        entityManager.getTransaction().begin();
//        Address address = new Address();
//        address.setText("Vitoshka 15");
//        entityManager.persist(address);
        entityManager.find(Employee.class, 291).setAddress(address);
//        entityManager.createQuery("UPDATE Employee e SET e.address = :address " +
//                "WHERE e.lastName = :name ").setParameter("name", lastName)
//                .setParameter("address", address).executeUpdate();
        entityManager.getTransaction().commit();
    }

    private Address createAddress(String text) {
        Address address = new Address();
        address.setText(text);
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        return address;
    }

    private void employeesFromDepartment() {
        entityManager.createQuery("SELECT e FROM Employee e WHERE e.department.name = 'Research and Development' " +
                "ORDER BY e.salary, e.id", Employee.class).getResultStream()
                .forEach(e -> System.out.printf("%s %s from %s - $%.2f%n",
                        e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary()));
    }

    private void employeesWithSalaryOver50000() {
        entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.salary > 50000", Employee.class).getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);

    }

    private void containsEmployee() throws IOException {
        String fullName = bf.readLine();
        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE concat(e.firstName, ' ', e.lastName) = :name", Employee.class)
                .setParameter("name", fullName)
                .getResultList();
        System.out.println(employees.isEmpty() ? "No" : "Yes");
    }

    private void changeCasing() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("SELECT t FROM Town t " +
                "WHERE length(t.name) <= 5 ", Town.class)
                .getResultStream().forEach(t -> {
            entityManager.detach(t);
            t.setName(t.getName().toLowerCase());
            entityManager.merge(t);
        });
        entityManager.getTransaction().commit();
//        List<Town> towns = entityManager.createQuery("SELECT t FROM Town t WHERE " +
//                "length(t.name) <= 5", Town.class)
//                .getResultList();
//        entityManager.getTransaction().begin();
//        towns.forEach(t->{
//            entityManager.detach(t);
//            t.setName(t.getName().toLowerCase());
//            entityManager.merge(t);
//        });
//        towns.forEach(entityManager::detach);
//        for (Town town : towns) {
//            town.setName(town.getName().toLowerCase());
//        }
//        towns.forEach(entityManager::merge);
//        entityManager.flush();
//        entityManager.getTransaction().commit();
    }
}
