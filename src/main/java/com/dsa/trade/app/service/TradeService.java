package com.dsa.trade.app.service;

import java.util.List;

import com.dsa.trade.app.model.Trade;

/**
 * 
 * @author Bharat Patel
 *
 */
public interface TradeService {
	public boolean isValid(Trade trade);

	public void persist(Trade trade);

	public List<Trade> findAll();

	public void updateExpiryFlagOfTrade();

}
