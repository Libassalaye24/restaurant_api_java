package com.restaurantapi.resrtaurantapi.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorDTO {
    private final String code;
    private final String message;

    public ErrorDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }


}
