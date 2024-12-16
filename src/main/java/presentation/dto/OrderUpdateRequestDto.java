package presentation.dto;

import domain.enums.OrderStatus;

public record OrderUpdateRequestDto(
        OrderStatus status
) {}
