package CodeSchool;

public class Human {

    private String name;
    private String surname;
    private int age;
    private boolean gender;

    //Default Constructor
    Human() {

    }


    //Constructors
    Human(String name, String surname, int age, boolean gender) {
        this.name = name;
        this.surname = surname;
        setAge(age);
        this.gender = gender;
    }


    //getters
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        if (gender) {
            return "Male";
        }
        return "Female";
    }


    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            this.age = 0;
        }
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    //toString method overide to Object
    @Override
    public String toString() {
        return name + ", " + surname + ", " + "age=" + age + ", " + "gender=" + getGender();
    }

}
