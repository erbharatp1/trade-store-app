package com.dsa.trade.app.repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.dsa.trade.app.model.Trade;
/**
 * 
 * @author Bharat Patel
 *
 */
public interface TradeDao {


    public  static Map<String,Trade> tradeMap =new ConcurrentHashMap<>();


    public void save(Trade trade);

    List<Trade> findAll();

    Trade findTrade(String tradeId);
}
