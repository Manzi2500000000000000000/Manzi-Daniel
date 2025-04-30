#!/bin/bash

echo "Lets Start the Projects!"
echo "1. Land Management"
echo "2. Mission Management"
echo "3. Nursery Management"
read -p "Enter your choice (1-3): " choice

case "$choice" in
    1)
        echo "Starting Land Management..."
        java -cp out Land_Management_System.Main
        ;;
    2)
        echo "Starting Mission Management..."
        java -cp out mission_management_system.Main
        ;;
    3)
        echo "Starting Nursery Management..."
        java -cp out nurserySchool_management_system.Main
        ;;
    *)
        echo "Invalid choice. Please try again."
        ;;
esac