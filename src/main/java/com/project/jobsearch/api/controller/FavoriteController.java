package com.project.jobsearch.api.controller;

import com.project.jobsearch.api.dto.CvDTO;
import com.project.jobsearch.api.dto.FavoriteDTO;
import com.project.jobsearch.api.entity.Cv;
import com.project.jobsearch.api.entity.Favorite;
import com.project.jobsearch.api.entity.User;
import com.project.jobsearch.api.service.CvService;
import com.project.jobsearch.api.service.FavoriteService;
import com.project.jobsearch.api.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class FavoriteController {

    private final FavoriteService favoriteService;
    private final UserService userService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService, UserService userService) {
        this.favoriteService = favoriteService;
        this.userService = userService;
    }

//    @GetMapping("/favorites")
//    public List<FavoriteDTO> getAll() {
//        ModelMapper modelMapper = new ModelMapper();
//        List<FavoriteDTO> favoritesDTO = new ArrayList<>();
//        List<Favorite> favorites =  favoriteService.getAll();
//
//        for (Favorite favorite: favorites ) {
//            FavoriteDTO favoriteDTO = modelMapper.map(favorite, FavoriteDTO.class);
//            favoritesDTO.add(favoriteDTO);
//        }
//        return favoritesDTO;
//    }

    @GetMapping("/favorite/{id}")
    public FavoriteDTO getById(@PathVariable Long id) {
        ModelMapper mapper = new ModelMapper();

        Optional<Favorite> favorite =  favoriteService.getById(id);
        Favorite f = favorite.get();
        FavoriteDTO favoriteDTO =  mapper.map(f, FavoriteDTO.class);
        return favoriteDTO;
    }

    @PostMapping("/favorites")
    public FavoriteDTO create(@RequestBody FavoriteDTO favoriteDTO) {
        ModelMapper mapper = new ModelMapper();
        Optional<User> user = this.userService.getById(favoriteDTO.getUserId());
        Favorite entity = mapper.map(favoriteDTO, Favorite.class);
        return mapper.map(favoriteService.create(entity, user.get()), FavoriteDTO.class);
    }

//    @PutMapping("/favorites/{id}")
//    public FavoriteDTO update(@RequestBody Favorite favorite, @PathVariable Long id) {
//        ModelMapper mapper = new ModelMapper();
//        FavoriteDTO favoriteDTO = mapper.map(favoriteService.update(favorite, id), FavoriteDTO.class);
//        return favoriteDTO;
//    }

    @DeleteMapping("favorites/{id}")
    public void delete(@PathVariable Long id) {
        favoriteService.delete(id);
    }

    @GetMapping("/favorite/user/{id}")
    public List<FavoriteDTO> getFavoritesByUserId(@PathVariable Long id) {
        ModelMapper mapper = new ModelMapper();
        List<FavoriteDTO> favoritesDTO = new ArrayList<>();
        List<Favorite> favorites = favoriteService.getAllByUserId(id);
        FavoriteDTO dto = null;

        for (Favorite fav : favorites) {
            dto = mapper.map(fav, FavoriteDTO.class);
            favoritesDTO.add(dto);
        }

        return favoritesDTO;
    }

}
