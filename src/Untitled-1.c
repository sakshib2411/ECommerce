#include <stdio.h>
#include <stdbool.h> // For boolean data type

#define MAX_SLOTS 5
#define REGISTRATION_LENGTH 9

struct ParkingSlot {
    char registration[REGISTRATION_LENGTH];
    bool occupied;
};

struct ParkingSlot parkingSlots[MAX_SLOTS];

// Initialize parking slots
void initializeSlots() {
    for (int i = 0; i < MAX_SLOTS; i++) {
        parkingSlots[i].occupied = false;
    }
}

// Function to park a car
void parkCar(char *registration) {
    for (int i = 0; i < MAX_SLOTS; i++) {
        if (!parkingSlots[i].occupied) {
            strcpy(parkingSlots[i].registration, registration);
            parkingSlots[i].occupied = true;
            printf("Car parked in slot %d\n", i + 1);
            return;
        }
    }
    printf("No empty slots available\n");
}

// Function to find the slot of a car or vice versa
void findSlotOrCar(char *query) {
    for (int i = 0; i < MAX_SLOTS; i++) {
        if (strcmp(query, parkingSlots[i].registration) == 0) {
            printf("Car %s is parked in slot %d\n", query, i + 1);
            return;
        } else if (atoi(query) == i + 1 && parkingSlots[i].occupied) {
            printf("Slot %d is occupied by car %s\n", i + 1, parkingSlots[i].registration);
            return;
        }
    }
    printf("Empty\n");
}

int main() {
    char registration[REGISTRATION_LENGTH];
    int choice;

    initializeSlots();

    while (true) {
        printf("\nMenu:\n");
        printf("1. Park a car\n");
        printf("2. Find a slot or car\n");
        printf("3. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter car registration number: ");
                scanf("%s", registration);
                parkCar(registration);
                break;
            case 2:
                printf("Enter car number or slot number: ");
                scanf("%s", registration);
                findSlotOrCar(registration);
                break;
            case 3:
                printf("Exiting program\n");
                return 0;
            default:
                printf("Invalid choice\n");
        }
    }

    return 0;
}
