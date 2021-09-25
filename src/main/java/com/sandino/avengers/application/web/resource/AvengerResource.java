package com.sandino.avengers.application.web.resource;

import static java.util.stream.Collectors.toList;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.sandino.avengers.application.web.resource.request.AvengerRequest;
import com.sandino.avengers.application.web.resource.response.AvengerResponse;
import com.sandino.avengers.domain.avenger.Avenger;
import com.sandino.avengers.domain.avenger.AvengerRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/avengers")
public class AvengerResource {

    private AvengerRepository repository;

    public AvengerResource(AvengerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<AvengerResponse>> getAvengers() {
        List<AvengerResponse> response = repository.getAvengers().stream().map(AvengerResponse::from).collect(toList());

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<AvengerResponse> createAvenger(@Valid @RequestBody AvengerRequest request) {
        Avenger avenger = repository.create(request.toAvenger());

        return ResponseEntity.created(URI.create("/v1/avengers/" + avenger.getId()))
                .body(AvengerResponse.from(avenger));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AvengerResponse> getAvengerDetails(@PathVariable long id) {
        try {
            Avenger avenger = repository.getDetail(id)
                    .orElseThrow(() -> new IllegalArgumentException("Element not found"));

            AvengerResponse response = AvengerResponse.from(avenger);

            return ResponseEntity.ok().body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<AvengerResponse> updateAvenger(@Valid @RequestBody AvengerRequest request,
            @PathVariable long id) {
        try {
            Avenger avenger = repository.getDetail(id)
                    .orElseThrow(() -> new IllegalArgumentException("Element not found"));

            Avenger updatedAvenger = repository.update(AvengerRequest.toAvenger(avenger.getId(), request));

            AvengerResponse response = AvengerResponse.from(updatedAvenger);

            return ResponseEntity.accepted().body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteAvenger(@PathVariable long id) {
        repository.delete(id);

        return ResponseEntity.accepted().build();
    }

}
