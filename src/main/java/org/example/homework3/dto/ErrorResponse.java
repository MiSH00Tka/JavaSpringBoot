package org.example.homework3.dto;

import java.util.Map;

public record ErrorResponse(String code, Map<String, String> errors) {
}
