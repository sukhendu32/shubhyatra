package com.masai.models;

public class Route {
	
	private String routeFrom;
	
	private String routeTo;
	
	
	public Route() {
		// TODO Auto-generated constructor stub
	}


	public Route(String routeFrom, String routeTo) {
		super();
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
	}


	public String getRouteFrom() {
		return routeFrom;
	}


	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}


	public String getRouteTo() {
		return routeTo;
	}


	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}


	@Override
	public String toString() {
		return "Route [routeFrom=" + routeFrom + ", routeTo=" + routeTo + "]";
	}
	
	
	
	

}
