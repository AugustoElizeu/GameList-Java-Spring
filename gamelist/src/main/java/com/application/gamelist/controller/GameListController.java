package com.application.gamelist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.gamelist.dto.GameListDTO;
import com.application.gamelist.dto.GameMinDTO;
import com.application.gamelist.services.GameListService;
import com.application.gamelist.services.GameService;

@RestController
@RequestMapping(value="/lists")
public class GameListController {
	
	@Autowired
	private GameListService gls;
	@Autowired
	private GameService gs;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		return gls.findAll();
	}
	
	@GetMapping(value="/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId) {
		List<GameMinDTO> result = gs.findByList(listId);
		return result;
	}
	
}
