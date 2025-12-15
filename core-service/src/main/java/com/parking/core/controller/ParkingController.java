package com.parking.core.controller;

import com.parking.core.model.ParkingSpot;
import com.parking.core.model.ReservationRequest;
import com.parking.core.service.ParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/spots")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ParkingController {

    private final ParkingService parkingService;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<ParkingSpot>>> getAllSpots() {
        List<EntityModel<ParkingSpot>> spots = parkingService.getAllSpots().stream()
            .map(spot -> EntityModel.of(spot,
                linkTo(methodOn(ParkingController.class).getAllSpots()).withSelfRel(),
                linkTo(methodOn(ParkingController.class).reserveSpot(null))
                    .withRel("reserve")))
            .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(spots,
            linkTo(methodOn(ParkingController.class).getAllSpots()).withSelfRel()));
    }

    @PostMapping("/reserve")
    public ResponseEntity<String> reserveSpot(@RequestBody ReservationRequest request) {
        try {
            parkingService.reserveSpot(request);
            return ResponseEntity.ok("Reservation successful");
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}