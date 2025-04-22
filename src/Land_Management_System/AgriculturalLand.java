package Land_Management_System;

import java.util.Date;

public class AgriculturalLand extends Land {

	public AgriculturalLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus) {
		super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
		
	}

	@Override
	public boolean validateOwnership() {
		return ownerName != null && !ownerName.trim().isEmpty();
	}

	@Override
	public boolean checkZoningCompliance() {
		return sizeInAcres >= 1 && location.trim().contains("farm");
	}

	@Override
	public double calculateTax() {
		return sizeInAcres * 5000 * 0.01;
	}

	@Override
	public void generateLandReport() {
		 printHeader("Agricultural");
	        System.out.println("Land ID: " + landId);
	        System.out.println("Owner: " + ownerName);
	        System.out.println("Location: " + location);
	        System.out.println("Size (Acres): " + sizeInAcres);
	        System.out.println("Registration Date: " + registrationDate);
	        System.out.println("Land Use Status: " + landUseStatus);
	        System.out.println("Ownership Valid: " + (validateOwnership() ? "Yes" : "No"));
	        System.out.println("Zoning Compliance: " + (checkZoningCompliance() ? "Yes" : "No"));
	        System.out.printf("Calculated Tax: $%.2f\n", calculateTax());
	        System.out.println("=============================================================================\n");
	}
	
	
      
	
}
