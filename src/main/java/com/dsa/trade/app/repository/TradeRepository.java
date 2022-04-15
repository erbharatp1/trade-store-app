package com.dsa.trade.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsa.trade.app.model.Trade;
/**
 * 
 * @author Bharat Patel
 *
 */
@Repository
public interface TradeRepository extends JpaRepository<Trade,String> {
}
