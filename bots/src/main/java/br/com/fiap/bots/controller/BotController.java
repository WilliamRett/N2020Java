package br.com.fiap.bots.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.bots.model.Bot;
import br.com.fiap.bots.repository.*;

@Controller
public class BotController {

	@Autowired
	private BotRepository br;

	@RequestMapping(value = "/bot/cadastros", method = RequestMethod.GET)
	public String form() {
		return "bot/formBot";
	}

	@RequestMapping(value = "/bot/cadastros", method = RequestMethod.POST)
	public String form(Bot bot) {
		br.save(bot);
		return "redirect:/bot/cadastros";
	}

	@RequestMapping(value = "/bot/{id_bot}", method = RequestMethod.POST)
	public String UpdateBot(Bot bot) {
		br.save(bot);
		return "redirect:/bot/{id_bot}";
	}

	@RequestMapping(value = "/bot", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("bot/bots");
		Iterable<Bot> bot = br.findAll();
		mv.addObject("bots", bot);
		return mv;
	}
	

	
	
	@RequestMapping("/bot/{id_bot}")
	public ModelAndView detalhesBot(@PathVariable("id_bot") long id_bot) {
		Bot bot = br.findById(id_bot);
		ModelAndView mv = new ModelAndView("bot/updateBot");
		mv.addObject("bots", bot);
		return mv;				
	}
	
	
	
	@RequestMapping("/bot/delete/{id_bot}")
	public String DeleteBot(@PathVariable("id_bot") long id_bot) {
		Bot bot = br.findById(id_bot);
		br.delete(bot);		
		return "redirect:/bot";
		
	}
	
	
	
}
