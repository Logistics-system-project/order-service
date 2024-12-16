package application.service;

import domain.entity.Order;
import domain.enums.OrderStatus;
import domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import presentation.dto.OrderCreateRequestDto;
import presentation.dto.OrderResponseDto;
import presentation.dto.OrderUpdateRequestDto;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderResponseDto createOrder(OrderCreateRequestDto requestDto) {
        Order order = Order.builder()
                .productId(requestDto.productId())
                .quantity(requestDto.quantity())
                .totalPrice(requestDto.quantity() * 100)
                .build();

        return OrderResponseDto.from(orderRepository.save(order));
    }

    public List<OrderResponseDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderResponseDto::from)
                .toList();
    }

    public OrderResponseDto getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
        return OrderResponseDto.from(order);
    }

    public OrderResponseDto updateOrder(Long id, OrderUpdateRequestDto requestDto) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        order.setStatus(requestDto.status());
        return OrderResponseDto.from(orderRepository.save(order));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
