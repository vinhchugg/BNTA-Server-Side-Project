package com.teamname.citizens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citizens")
public class CitizenController {
    private CitizenService citizenService;

    @Autowired
    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @GetMapping
    public List<Citizen> getAllCitizens() {
        return citizenService.getAllCitizens();
    }

    @GetMapping("ofHouse/{houseID}")
    public List<Citizen> getCitizensOfHouse(@PathVariable("houseID") Integer houseID) {
        return citizenService.getCitizensOfHouse(houseID);
    }

    @GetMapping("ofWorkplace/{workplaceID}")
    public List<Citizen> getCitizensOfWorkplace(@PathVariable("workplaceID") Integer workplaceID) {
        return citizenService.getCitizensOfWorkplace(workplaceID);}


    @GetMapping("{id}")
    public Optional<Citizen> getCitizenById(@PathVariable("id") Integer id) {
        return citizenService.getCitizenById(id);
    }

    @PostMapping
    public void insertCitizen(@RequestBody Citizen citizen) {
        citizenService.insertCitizen(citizen);
    }

    @DeleteMapping("{id}")
    public void deleteCitizen(@PathVariable("id") @RequestBody Integer id) {
        citizenService.deleteCitizen(id);
    }

    @PutMapping("{id}")
    public void updateCitizen(@PathVariable("id") Integer id, @RequestBody Citizen citizen) {
        citizenService.updateCitizen(id, citizen);
    }


}
