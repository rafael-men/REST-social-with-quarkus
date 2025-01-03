package io.rafaelmen.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import javax.xml.transform.Source;

public class CreateUserRequest implements Source {

    @NotBlank(message = "Name required")
    private String name;
    @NotNull(message = "Age required")
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

    @Override
    public void setSystemId(String systemId) {

    }

    @Override
    public String getSystemId() {
        return "";
    }

    @Override
    public boolean isEmpty() {
        return Source.super.isEmpty();
    }
}
