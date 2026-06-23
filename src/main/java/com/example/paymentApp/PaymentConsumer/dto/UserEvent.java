package com.example.paymentApp.PaymentConsumer.dto;

public class UserEvent {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public UserEvent(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    private String name;
    private String address;

    // Standard Boilerplate (or use Lombok @Data)
    public UserEvent() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserDto{name='" + name + "', address='" + address + "'}";
    }

}