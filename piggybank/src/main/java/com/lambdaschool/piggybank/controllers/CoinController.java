package com.lambdaschool.piggybank.controllers;


import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



@RestController
public class CoinController {
	CoinRepository coinRepo;


	/**
	 * Autowired Constructor
	 *
	 * @param coinRepo CoinRepository interface
	 */
	@Autowired
	public CoinController(CoinRepository coinRepo) {
		this.coinRepo = coinRepo;
	}


	/**
	 * Helper function to acquire the full list of coins in CoinRepository
	 * @return List of all coins in CoinRepository
	 */
	@NotNull
	private List<Coin> getStarterList() {
		List<Coin> coins = new ArrayList<>();
		coinRepo.findAll()
		        .iterator()
		        .forEachRemaining(coins::add);
		return coins;
	}

}
