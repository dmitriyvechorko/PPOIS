public class Person {
    protected String name;
    protected int age;
    /**
     * Данный конструктор принимает
     * следующие параметры:
     * @param name Имя человека.
     * @param age Его возраст.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
}
