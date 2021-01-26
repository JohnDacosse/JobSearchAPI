package com.project.jobsearch.api.controller;

import com.project.jobsearch.api.dto.LicenseDTO;
import com.project.jobsearch.api.entity.License;
import com.project.jobsearch.api.service.CvService;
import com.project.jobsearch.api.service.LicenseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class LicenseController {

    private final LicenseService licenseService;
    private final CvService cvService;

    @Autowired
    public LicenseController(LicenseService licenseService, CvService cvService) {
        this.licenseService = licenseService;
        this.cvService = cvService;
    }

    @GetMapping("/licenses")
    public List<LicenseDTO> getAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<LicenseDTO> licensesDTO = new ArrayList<>();
        List<License> licenses =  licenseService.getAll();

        for (License license: licenses ) {
            LicenseDTO licenseDTO = modelMapper.map(license, LicenseDTO.class);
            licensesDTO.add(licenseDTO);
        }
        return licensesDTO;
    }

    @GetMapping("/license/{id}")
    public LicenseDTO getById(@PathVariable Long id) {
        ModelMapper mapper = new ModelMapper();

        Optional<License> license =  licenseService.getById(id);
        License l = license.get();
        LicenseDTO licenseDTO =  mapper.map(l, LicenseDTO.class);
        return licenseDTO;
    }

//    @PostMapping("/licenses")
//    public LicenseDTO create(@RequestBody LicenseDTO licenseDTO) {
//        ModelMapper mapper = new ModelMapper();
////        Optional<License> license = this.cvService.getById(licenseDTO.getCvs());
////        Favorite entity = mapper.map(favoriteDTO, Favorite.class);
////        return mapper.map(favoriteService.create(entity, user.get()), FavoriteDTO.class);
//        return null;
//    }

//    @PutMapping("/licenses/{id}")
//    public LicenseDTO update(@RequestBody License license, @PathVariable Long id) {
//        ModelMapper mapper = new ModelMapper();
//        LicenseDTO licenseDTO = mapper.map(licenseService.update(license, id), LicenseDTO.class);
//        return licenseDTO;
//    }

//    @DeleteMapping("licenses/{id}")
//    public void delete(@PathVariable Long id) {
//        licenseService.delete(id);
//    }

//    @GetMapping("/favorite/user/{id}")
//    public FavoriteDTO getCvByUserId(@PathVariable Long id) {
//        ModelMapper mapper = new ModelMapper();
//        FavoriteDTO favoriteDTO = mapper.map(favoriteService.getByUserId(id), FavoriteDTO.class);
//        return favoriteDTO;
//    }

}
