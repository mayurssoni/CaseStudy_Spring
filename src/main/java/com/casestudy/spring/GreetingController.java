package com.casestudy.spring;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

//Usage /greeting?name=Mayur
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

//usage /countcharacters?word=String
        @GetMapping("/countcharacters")
        public String countChar(@RequestParam(name="word",required=false, defaultValue="World") String word, Model model) {
		int vcount = 0;
		int ccount = 0;
		word=word.toLowerCase();
		for(int i = 0; i < word.length(); i++) { 
			char ch = word.charAt(i); 
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				vcount++; 
			} else if((ch >= 'a'&& ch <= 'z')) {
                		ccount++;
			}
        	}
		model.addAttribute("vcount",vcount);
                model.addAttribute("ccount",ccount);
                return "countcharacters";
        }
}
