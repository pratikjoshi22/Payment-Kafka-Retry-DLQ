package com.example.paymentApp.PaymentConsumer.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "User event payload sent to Kafka")
public class UserEvent {





    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Schema(description = "Unique user ID", example = "user-123")
    private String id;

    public UserEvent(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Schema(description = "User name", example = "John Doe")
    private String name;

    @Schema(description = "User address", example = "123 Main St")
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