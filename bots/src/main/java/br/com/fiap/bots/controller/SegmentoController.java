package br.com.fiap.bots.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.bots.model.Bot;
import br.com.fiap.bots.model.Segment;
import br.com.fiap.bots.repository.BotRepository;
import br.com.fiap.bots.repository.SegmentRepository;

@Controller
public class SegmentoController {

	@Autowired
	private BotRepository br;
	@Autowired
	private SegmentRepository sr;

	@RequestMapping(value = "/segment/cadastros", method = RequestMethod.POST)
	public String SaveSagment(Segment segment) {
		sr.save(segment);
		return "redirect:/segment/cadastros";

	}

	@RequestMapping(value = "/segment/cadastros", method = RequestMethod.GET)
	public ModelAndView cadastroList() {
		ModelAndView mv = new ModelAndView("segment/formSegment");
		Iterable<Bot> bot = br.findAll();
		mv.addObject("bots", bot);
		return mv;
	}

	@RequestMapping(value = "/segment", method = RequestMethod.GET)
	public ModelAndView List() {
		ModelAndView mv = new ModelAndView("segment/segments");
		Iterable<Segment> segment = sr.findAll();
		Iterable<Bot> bot = br.findAll();
		mv.addObject("bots", bot);
		mv.addObject("segments", segment);
		return mv;
	}

	@RequestMapping(value = "/segment/{id_segment}", method = RequestMethod.POST)
	public String UpdateBot(Segment segment) {
		sr.save(segment);
		return "redirect:/segment/{id_segment}";
	}

	@RequestMapping("/segment/{id_segment}")
	public ModelAndView detalhesSegment(@PathVariable("id_segment") long id_segment) {
		Segment segment = sr.findById(id_segment);
		Iterable<Bot> bot = br.findAll();
		ModelAndView mv = new ModelAndView("segment/updateSegment");
		mv.addObject("bots", bot);
		mv.addObject("segments", segment);
		return mv;
	}

	@RequestMapping("/segment/delete/{id_segment}")
	public String DeleteSegment(@PathVariable("id_segment") long id_segment) {
		Segment segment = sr.findById(id_segment);
		sr.delete(segment);
		return "redirect:/segment";

	}

}
