package com.gdu.movie.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.gdu.movie.domain.MovieDTO;

public interface MovieService {
	
	public List<MovieDTO> getAllMovies();
	public Map<String, Object> selectMoviesByQuery(HttpServletRequest request);
	
}
