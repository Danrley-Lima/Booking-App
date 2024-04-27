package com.web2.booking.DTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateProductOutputDTO(UUID id, String title, String city, String state, String image, double price,
                double customerScore, int numberOfReviews, int discount, double totalPrice,
                LocalDateTime createdAt) {

}
