package com.application.gamelist.projections;

public interface GameMinProjection {

	Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getGenre();
	String getShortDescription();
	Integer getPosition();
}
