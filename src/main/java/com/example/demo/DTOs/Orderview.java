package com.example.demo.DTOs;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class Orderview {
    private Long id;
    private String city;
    private String deliveryStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private Long productId;
    private Long customerId;
    private String customerName;
    private String productName;

    // Default constructor
    public Orderview() {}

    // Parameterized constructor
    public Orderview(Long id, String city, String deliveryStatus, Date date, Long productId, Long customerId, String customerName, String productName) {
        this.id = id;
        this.city = city;
        this.deliveryStatus = deliveryStatus;
        this.date = date;
        this.productId = productId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.productName = productName;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
