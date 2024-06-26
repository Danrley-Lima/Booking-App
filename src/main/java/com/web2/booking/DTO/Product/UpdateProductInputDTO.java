package com.web2.booking.DTO.Product;

import org.springframework.cglib.core.Local;

public record UpdateProductInputDTO(String title, String description, String mainImage,
    double price, int discount, int quantity, Local startDate, Local endDate) {

}
