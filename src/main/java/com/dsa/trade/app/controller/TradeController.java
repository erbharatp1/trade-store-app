package com.dsa.trade.app.controller;

import com.dsa.trade.app.exception.InvalidTradeException;
import com.dsa.trade.app.model.Trade;
import com.dsa.trade.app.service.TradeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 
 * @author Bharat Patel
 *
 */
@RestController
public class TradeController {
	@Autowired
	TradeServiceImpl tradeService;

	@PostMapping("/trade")
	public ResponseEntity<String> tradeValidateStore(@RequestBody Trade trade) {
		if (tradeService.isValid(trade)) {
			tradeService.persist(trade);
		} else {

			throw new InvalidTradeException(trade.getTradeId() + "  Trade Id is not found");
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/trade")
	public List<Trade> findAllTrades() {
		return tradeService.findAll();
	}
}
