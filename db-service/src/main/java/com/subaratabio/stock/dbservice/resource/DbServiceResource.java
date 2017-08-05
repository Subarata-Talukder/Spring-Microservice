package com.subaratabio.stock.dbservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subaratabio.stock.dbservice.model.Quote;
import com.subaratabio.stock.dbservice.model.Quotes;
import com.subaratabio.stock.dbservice.repository.QoutesRepository;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

	private QoutesRepository quotesRepository;

	public DbServiceResource(QoutesRepository quotesRepository) {
		this.quotesRepository = quotesRepository;
	}

	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") final String username) {

		return getQuotesByUserName(username);
	}

	@PostMapping("/add")
	public List<String> add(@RequestBody final Quotes quotes) {

		quotes.getQuotes().stream().map(quote -> new Quote(quotes.getUserName(), quote))
				.forEach(quote -> quotesRepository.save(quote));
		return getQuotesByUserName(quotes.getUserName());
	}

	@PostMapping("/delete/{username}")
	public List<String> delete(@PathVariable("username") final String username) {

		List<Quote> quotes = quotesRepository.findByUserName(username);
		quotesRepository.delete(quotes);

		return getQuotesByUserName(username);
	}

	private List<String> getQuotesByUserName(@PathVariable("username") String username) {
		return quotesRepository.findByUserName(username).stream().map(Quote::getQuote).collect(Collectors.toList());
	}

}