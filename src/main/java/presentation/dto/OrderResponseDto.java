package presentation.dto;

import domain.entity.Order;

import java.time.LocalDateTime;

public record OrderResponseDto(
        Long id,
        Long productId,
        Integer quantity,
        Integer totalPrice,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static OrderResponseDto from(Order order) {
        return new OrderResponseDto(
                order.getId(),
                order.getProductId(),
                order.getQuantity(),
                order.getTotalPrice(),
                order.getStatus().name(),
                order.getCreatedAt(),
                order.getUpdatedAt()
        );
    }
}
