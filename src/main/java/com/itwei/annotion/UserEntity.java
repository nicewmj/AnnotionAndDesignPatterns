package com.itwei.annotion;

@SetTable("user_table")
public class UserEntity {

    @SetPorpert(name = "user_name",leng = 10)
    private String name;
    @SetPorpert(name = "user_age",leng = 10)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
