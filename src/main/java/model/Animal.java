package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author izael
 */
public class Animal {
    //Attributes
    private int id;
    private String name;
    private int age;
    private String gender;
    private String specie;
    private int idClient;

    //Constructor
    public Animal(int id, String name, int age, String gender, String specie, int idClient) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.specie = specie;
        this.idClient = idClient;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getSpecie() {
        return specie;
    }
    
    public int getIdClient() {
        return idClient;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }
    
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "\n\t\tID: " + id + "\n\t\tNome: " + name + "\n\t\tIdade: " + age + "\n\t\tGênero: " + gender + "\n\t";
    }
}
