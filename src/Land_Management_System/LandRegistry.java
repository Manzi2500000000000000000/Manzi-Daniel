package Land_Management_System;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LandRegistry {
    private List<Land> lands = new ArrayList<>();
    
    public void registerLand(Land land) {
    	lands.add(land);
    	System.out.println("Land registered Successfully");
    }
    
    
    public List<Land> searchByOwner(String ownerName) {
    	return lands.stream()
    			.filter(land -> land.ownerName.equalsIgnoreCase(ownerName))
    			.collect(Collectors.toList());
    }
    
    
    public List<Land> searchByLocation(String location) {
    	return lands.stream()
                .filter(land -> land.location.toLowerCase().contains(location.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    public List<Land> searchByType(String type) {
    	return lands.stream()
    			.filter(land -> land.getClass().getSimpleName().equalsIgnoreCase(type + "Land"))
                .collect(Collectors.toList());
    }
    
    public List<Land> getAllLands() {
    	return lands;
    }
}
