package com.lambdaschool.piggybank.controllers;


import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;

import java.util.ArrayList;
import java.util.List;



public class HelperFunctions {
	/**
	 * Taking in a Coin Repository, find all tracked coins
	 *
	 * @param coinRepo CoinRepository holding desired information
	 *
	 * @return List of all Coins within CoinRepository
	 */
	public static List<Coin> findStarterList(CoinRepository coinRepo) {
		List<Coin> coins = new ArrayList<>();
		coinRepo.findAll()
		        .iterator()
		        .forEachRemaining(coins::add);
		return coins;
	}

}
