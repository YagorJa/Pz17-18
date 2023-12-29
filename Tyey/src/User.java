public class User {
    private String name;
    private Integer age;
    private String lastName;
    private boolean hasAnimal;

//    private User(String name, Integer age, String lastName, boolean hasAnimal) {
//        this.name = name;
//        this.age = age;
//        this.lastName = lastName;
//        this.hasAnimal = hasAnimal;
//    }
    public static User builder(){
        return new User();
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public boolean isHasAnimal() {
        return hasAnimal;
    }

    public User setHasAnimal(boolean hasAnimal) {
        this.hasAnimal = hasAnimal;
        return this;
    }
}
