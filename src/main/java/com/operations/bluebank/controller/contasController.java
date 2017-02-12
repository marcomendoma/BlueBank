package com.operations.bluebank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.operations.bluebank.model.Conta;
import com.operations.bluebank.service.IContaServiceImpl;

@Controller
public class contasController {

	@Autowired
	private IContaServiceImpl repository;
	
	@RequestMapping("/contas")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaContas");
		mv.addObject("conta", new Conta());
		mv.addObject("contas", repository.listAllcontas());
		return mv;
	}
	
	@RequestMapping("/transferencia")
	public String transferencia(Model model) {
		model.addAttribute("conta", new Conta());
        return "transferencia";
	}
	
	@RequestMapping("/conta")
    public ModelAndView newConta(Conta conta){
        ModelAndView mv = new ModelAndView("conta");
        mv.addObject("conta", new Conta());
        mv.addObject("contas", repository.listAllcontas());
        return mv;
    }
	
	@RequestMapping("/conta/{id}")
    public String showConta(@PathVariable Long id, Model model){
        model.addAttribute("conta", repository.getContaById(id));
        return "conta";
    }

	@RequestMapping(value="conta", method = RequestMethod.POST) 
	public ModelAndView Salvar(@Valid Conta conta, BindingResult result) {
		if (result.hasErrors()){
			return newConta(conta);
		}
		
		this.repository.saveConta(conta); 
		return new ModelAndView("redirect:/contas");
	}
}
