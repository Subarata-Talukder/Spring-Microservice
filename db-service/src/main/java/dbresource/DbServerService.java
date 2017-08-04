package dbresource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Qoute;
import model.Quotes;
import reporesource.QuoutesRepo;

@RestController
@RequestMapping("/db")
public class DbServerService {
	
	private QuoutesRepo quoutesRepository;

	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") final String username){
		
		return quoutesRepository.findByUserName(username)
		.stream()
		.map(Qoute::getQouteName)
		.collect(Collectors.toList());
	}
	
	@PostMapping("/add")
    public List<String> add(@RequestBody final Quotes quotes) {


        /*quotes.getQuotes()
                .stream()
                .map(quote -> new Quote(quotes.getUserName(), quote))
                .forEach(quote -> quotesRepository.save(quote));
        
        return getQuotesByUserName(quotes.getUserName());*/
		
		return null;
    }

}
