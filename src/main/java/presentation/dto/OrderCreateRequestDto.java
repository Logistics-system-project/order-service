package presentation.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderCreateRequestDto(
        @NotNull Long productId,
        @Positive Integer quantity
) {}
