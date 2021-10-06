package com.games.ecommerce.gamespayment.repository;

import com.games.ecommerce.gamespayment.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutGamesRepository extends JpaRepository<CheckoutEntity, Long> {
}
