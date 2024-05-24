package org.example.homework3.dto;


import org.example.homework3.validation.CustomValidationAnnotation;

public record StringRequest(@CustomValidationAnnotation String string) {
}
