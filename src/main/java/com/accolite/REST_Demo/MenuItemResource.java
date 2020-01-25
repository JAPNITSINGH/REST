package com.accolite.REST_Demo;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// http://localhost:8980/REST_Demo/webapi/menuitem
@Path("menuitem")
public class MenuItemResource {
	List<MenuItem> menu = new ArrayList<MenuItem>();
	@GET
	@Produces(MediaType.APPLICATION_XML) //@Produces(MediaType.APPLICATION_JSON) use this for JSON
	public List<MenuItem> getMenuItem()
	{	
		if(menu.isEmpty())
		{
			MenuItem menuItem = new MenuItem();
			menuItem.setItemName("Butter Chicken");
			menuItem.setCost(400);
			MenuItem menuItem2 = new MenuItem();
			menuItem2.setItemName("Butter Paneer");
			menuItem2.setCost(300);
			MenuItem menuItem3 = new MenuItem();
			menuItem3.setItemName("Butter Naan");
			menuItem3.setCost(200);

			// listOfMenuItems = Menu   Change the variable name later.

			menu.add(menuItem);
			menu.add(menuItem2);
			menu.add(menuItem3);
		}
		
		
		return menu; 
	}
	
//	 http://localhost:8980/REST_Demo/webapi/menuitem/addMenuItem
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	@Path("addMenuItem")
	public void addMenuItem()
	{
		MenuItem mi = new MenuItem();
		//mi.setCost(cost);
		mi.setCost(100);
		mi.setItemName("New Item");
		menu.add(mi);
		System.out.println("New Item Added");
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	@Path("updateMenuItem")
	public void updateMenuItem()
	{
		MenuItem old_mi = new MenuItem();
		old_mi.setCost(100);
		old_mi.setItemName("New Item");
		for(MenuItem m : menu)
		{
			if(m.getItemName().equals(old_mi.getItemName()))
					{
						m.setCost(150);// m.setCost(newCost)
						m.setItemName("Replaced_Name");//m.setCost(newName)
					}
		}
		//menu.add(mi);
		System.out.println("New Item Added");
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	@Path("updateMenuItem")
	public void deleteMenuItem()
	{
		MenuItem old_mi = new MenuItem();
		//old_mi.setCost(100);
		old_mi.setItemName("Butter Naan");
		for(MenuItem m : menu)
		{
			if(m.getItemName().equals(old_mi.getItemName()))
					{
						menu.remove(m);
					}
		}
		//menu.add(mi);
		System.out.println("New Item Added");
	}
	
	
	
}
