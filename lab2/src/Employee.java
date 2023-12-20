public class Employee extends Person {
    protected double salary;
    protected int employeeId;
    /**
     * Данный конструктор принимает
     * следующие параметры:
     * @param name Имя работника.
     * @param employeeId Id номер работника в минимаркете.
     * @param age Возраст работника.
     * @param salary Зарплата работника.
     */
    public Employee(String name, int employeeId, int age, double salary) {
        super(name, age);
        this.employeeId = employeeId;
        this.salary = salary;
    }
    public double getSalary() {return salary;}
    public void setSalary(double salary) {this.salary = salary;}
    public int getEmployeeId() {return employeeId;}
    public void setEmployeeId(int employeeId) {this.employeeId = employeeId;}
    @Override
    public String toString() {return "Name: " + this.name + ", EmployeeId: " + this.employeeId + ", Age: " + this.age + ", Salary: " + this.salary;}

    /**
     * Метод вывода информации о работнике
     */
    public void displayEmployeeInfo(Employee employee) {
        String employeeInfo = employee.toString();
        System.out.println(employeeInfo);
    }
}