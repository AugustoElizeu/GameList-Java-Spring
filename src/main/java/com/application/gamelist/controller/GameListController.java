package com.application.gamelist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.gamelist.dto.GameListDTO;
import com.application.gamelist.services.GameListService;

@RestController
@RequestMapping(value="/lists")
public class GameListController {
	
	@Autowired
	private GameListService gls;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		return gls.findAll();
	}
	
}
