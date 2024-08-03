package com.example.progressify.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private String message;
    private String token; // Optional: Use this field for authentication responses
    private Object data; // Optional: Use this field to send additional data
}
