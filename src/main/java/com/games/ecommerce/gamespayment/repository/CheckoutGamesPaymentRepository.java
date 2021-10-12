package com.games.ecommerce.gamespayment.repository;

import com.games.ecommerce.gamespayment.entity.CheckoutPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface CheckoutGamesPaymentRepository extends JpaRepository<CheckoutPaymentEntity, Long> {
}
