package com.application.gamelist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.gamelist.dto.GameDTO;
import com.application.gamelist.dto.GameMinDTO;
import com.application.gamelist.services.GameService;

//É quem implementa essa api
@RestController
@RequestMapping(value="/games")
public class GameController {
	
	@Autowired
	private GameService gs;
	
	@GetMapping(value="/{id}")
	public GameDTO findById(@PathVariable Long id) {
		GameDTO result = gs.findById(id);
		return result;
	}
	@GetMapping
	public List<GameMinDTO> findAllGames() {
		List<GameMinDTO> result = gs.findAll();
		return result;
	}
	
	
}
