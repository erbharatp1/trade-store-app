package com.dsa.trade.app.service;

import com.dsa.trade.app.model.Trade;
import com.dsa.trade.app.repository.TradeDao;
import com.dsa.trade.app.repository.TradeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * 
 * @author Bharat Patel
 *
 */
@Service
public class TradeServiceImpl implements TradeService {

	private static final Logger log = LoggerFactory.getLogger(TradeServiceImpl.class);

	@Autowired
	TradeDao tradeDao;

	@Autowired
	TradeRepository tradeRepository;

	public boolean isValid(Trade trade) {
		if (validateMaturityDate(trade)) {

			Optional<Trade> exsitingTrade = tradeRepository.findById(trade.getTradeId());
			if (exsitingTrade.isPresent()) {
				return validateVersion(trade, exsitingTrade.get());
			} else {
				return true;
			}
		}
		return false;
	}

	private boolean validateVersion(Trade trade, Trade oldTrade) {

		if (trade.getVersion() >= oldTrade.getVersion()) {
			return true;
		}
		return false;
	}

	private boolean validateMaturityDate(Trade trade) {
		return trade.getMaturityDate().isBefore(LocalDate.now()) ? false : true;
	}

	public void persist(Trade trade) {

		trade.setCreatedDate(LocalDate.now());
		tradeRepository.save(trade);
	}

	public List<Trade> findAll() {
		return tradeRepository.findAll();

	}

	public void updateExpiryFlagOfTrade() {

		tradeRepository.findAll().stream().forEach(t -> {
			if (!validateMaturityDate(t)) {
				t.setExpiredFlag("Y");
				log.info("Trade which needs to updated {}", t);
				tradeRepository.save(t);
			}
		});
	}

}
