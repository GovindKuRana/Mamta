package com.lcwd.hotal.Controller;

import com.lcwd.hotal.Entity.Hotal;
import com.lcwd.hotal.Servicce.HotalService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotal")
public class HotalController {
    @Autowired
    private HotalService service;
    @PostMapping("/add")
    public ResponseEntity<Hotal> addHotal(@RequestBody Hotal hotal)
    {
        Hotal hotal1=service.addHotal(hotal);
        return new ResponseEntity<>(hotal1, HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteHotal(@RequestParam int id)
    {
        service.deleteHotal(id);
        return new ResponseEntity<>("delet", HttpStatus.OK);
    }
    @GetMapping
    public List<Hotal> getAllHotal()
    {
        List<Hotal>hotals=service.getAllHotal();
        return new ResponseEntity<>(hotals, HttpStatus.OK).getBody();
    }
    @PutMapping
    public ResponseEntity<String> updateHotal(@RequestParam int id,@RequestBody Hotal hotal)
    {
        service.updateHotal(id,hotal);
        return new ResponseEntity<>("update", HttpStatus.OK);
    }


}
