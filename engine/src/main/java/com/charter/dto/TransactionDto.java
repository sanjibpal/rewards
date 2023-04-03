package com.charter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class TransactionDto {
    @NotEmpty(message="Amount can not be empty")
    Float amount;
}
