package Land_Management_System;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
      private static final Scanner scanner = new Scanner(System.in);
      private static final LandRegistry registry = new LandRegistry();
      
      public static void main(String[] args) {
		boolean exit = false;
		while(!exit) {
			    System.out.println("===== LAND MANAGEMENT SYSTEM =====");
	            System.out.println("1. Register Land");
	            System.out.println("2. Search Land by Owner");
	            System.out.println("3. Search Land by Location");
	            System.out.println("4. Search Land by Type");
	            System.out.println("5. Show All Land Reports");
	            System.out.println("6. Exit");
	            System.out.print("Choose an option: ");
	            int option = Integer.parseInt(scanner.nextLine());
	            
	            switch(option) {
	                case 1 -> registerLand();
	                case 2 -> searchLandByOwner();
	                case 3 -> searchLandByLocation();
	                case 4 -> searchLandByType();
	                case 5 -> showAllReports();
	                case 6 -> exit = true;
	                default -> System.out.println("Invalid option. Try again.");
	            }
	        }
		}
      
      private static void registerLand() {
    	  try {
    		  System.out.println("Enter Land ID: ");
    		  String landId = scanner.nextLine();
    		  
    		  String ownerName;
    		  while(true) {
    			  System.out.print("Enter Owner Name (letters only): ");
                  ownerName = scanner.nextLine();
                  if (ownerName.matches("[a-zA-Z ]+")) break;
                  System.out.println("Invalid name. Please use letters only.");
    		  }
    		  
    		  System.out.print("Enter Location: ");
              String location = scanner.nextLine();

              System.out.print("Enter Size in Acres: ");
              double sizeInAcres = Double.parseDouble(scanner.nextLine());

              System.out.print("Enter Registration Date (yyyy-MM-dd): ");
              Date registrationDate = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine());

              System.out.print("Enter Land Use Status: ");
              String landUseStatus = scanner.nextLine();

              System.out.println("Select Land Type: ");
              System.out.println("1. Agricultural");
              System.out.println("2. Residential");
              System.out.println("3. Commercial");
              System.out.println("4. Industrial");
              int type = Integer.parseInt(scanner.nextLine());
    		  
              Land land = null;
              switch(type) {
              case 1 -> land = new AgriculturalLand(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
              case 2 -> {
                  System.out.print("Enter Number of Residential Units: ");
                  int units = Integer.parseInt(scanner.nextLine());
                  land = new ResidentialLand(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus, units);
              }
              case 3 -> land = new CommercialLand(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
              case 4 -> {
                  System.out.print("Has Environmental Clearance? (yes/no): ");
                  boolean clearance = scanner.nextLine().equalsIgnoreCase("yes");
                  land = new IndustrialLand(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus, clearance);
              }
              default -> System.out.println("Invalid land type selected.");
              }
              
              if (land != null) {
                  registry.registerLand(land);
                  land.generateLandReport();
              }
              
    	  } catch (ParseException | NumberFormatException e) {
    		  System.out.println("Error: Invalid input format. Please try again.");
    	  }
      }
      
      private static void searchLandByOwner() {
          System.out.print("Enter Owner Name: ");
          String owner = scanner.nextLine();
          List<Land> results = registry.searchByOwner(owner);
          results.forEach(Land::generateLandReport);
      }
      
      private static void searchLandByLocation() {
          System.out.print("Enter Location Keyword: ");
          String location = scanner.nextLine();
          List<Land> results = registry.searchByLocation(location);
          results.forEach(Land::generateLandReport);
      }
      
      private static void searchLandByType() {
          System.out.print("Enter Land Type (Agricultural, Residential, Commercial, Industrial): ");
          String type = scanner.nextLine();
          List<Land> results = registry.searchByType(type);
          results.forEach(Land::generateLandReport);
      }
      
      private static void showAllReports() {
          List<Land> lands = registry.getAllLands();
          if (lands.isEmpty()) {
              System.out.println("No lands registered yet.");
          } else {
              lands.forEach(Land::generateLandReport);
          }
      }
      
	}

