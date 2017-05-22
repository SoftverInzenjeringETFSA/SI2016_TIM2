package ba.posao.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ba.posao.models.Korisnik;
import ba.posao.models.PoljaTemplatea;
import ba.posao.models.Template;
import ba.posao.repositories.PoljaTemplateaRepository;
import ba.posao.repositories.TemplateRepository;

@Service
public class TemplateService {
	
	@Autowired
	TemplateRepository repository;
	
	@Autowired
	PoljaTemplateaRepository poljaTemplateaRepository;
	
	
	
	
	public Template findById(Integer id) 
	{
		return repository.findById(id);
	}
	
	public Boolean addTemplate(Template template) {
		Template t =repository.save(template);
		for (int i=0; i<template.getPoljaTemplatea().size(); i++)
		{
			PoljaTemplatea temp =(PoljaTemplatea) template.getPoljaTemplatea().toArray()[i];
			temp.setTemplate(t);
			poljaTemplateaRepository.save(temp);
		}	
		return true;
	}

}
