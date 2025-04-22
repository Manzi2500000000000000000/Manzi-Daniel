package Land_Management_System;

import java.util.Date;

public class ResidentialLand extends Land {
    private int numberOfUnits;

	public ResidentialLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus, int numberOfUnits) {
		super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
		this.numberOfUnits = numberOfUnits;
	}

	@Override
	public boolean validateOwnership() {	
		return ownerName != null && !ownerName.trim().isEmpty();
	}

	@Override
	public boolean checkZoningCompliance() {
		return numberOfUnits <= (2 * sizeInAcres);
	}

	@Override
	public double calculateTax() {
		 return sizeInAcres * 8000 * 0.015;
	}

	@Override
	public void generateLandReport() {
		 printHeader("Residential");
	        System.out.println("Land ID: " + landId);
	        System.out.println("Owner: " + ownerName);
	        System.out.println("Location: " + location);
	        System.out.println("Size (Acres): " + sizeInAcres);
	        System.out.println("Number of Units: " + numberOfUnits);
	        System.out.println("Registration Date: " + registrationDate);
	        System.out.println("Land Use Status: " + landUseStatus);
	        System.out.println("Ownership Valid: " + (validateOwnership() ? "Yes" : "No"));
	        System.out.println("Zoning Compliance: " + (checkZoningCompliance() ? "Yes" : "No"));
	        System.out.printf("Calculated Tax: $%.2f\n", calculateTax());
	        System.out.println("=============================================================================\n");
		
	}
    
	
    
}
