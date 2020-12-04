package com.lambdaschool.piggybank.controllers;


import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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


//	/**
//	 * Helper function to acquire the full list of coins in CoinRepository
//	 * @return List of all coins in CoinRepository
//	 */
//	@NotNull
//	private List<Coin> getStarterList() {
//		List<Coin> coins = new ArrayList<>();
//		coinRepo.findAll()
//		        .iterator()
//		        .forEachRemaining(coins::add);
//		return coins;
//	}

	/**
	 * Prints to the console the contents of the PiggyBank and returns an HTTP status of OK
	 * <br>Example: <a href="http://localhost:2019/total">http://localhost:2019/total</a>
	 * @return HTTP status of OK
	 */
	@GetMapping(value="/total", produces={"application/json"})
	public ResponseEntity<?> listTotalContents() {
		List<Coin> coins = HelperFunctions.findStarterList(coinRepo);
		long total = 0;
		for (Coin c : coins) {
			long q = c.getQuantity();
			String n = c.getName();
			if (q > 1) {
				n = c.getNameplural();
			}
			total += q;

			System.out.println(q + " " + n);
		}
		System.out.println("The piggy bank holds " + total);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
