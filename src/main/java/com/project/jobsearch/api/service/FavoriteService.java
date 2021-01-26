package com.project.jobsearch.api.service;

import com.project.jobsearch.api.entity.Cv;
import com.project.jobsearch.api.entity.Favorite;
import com.project.jobsearch.api.entity.User;
import com.project.jobsearch.api.repository.ICvRepository;
import com.project.jobsearch.api.repository.IFavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author johnd
 * @version 1.0
 */
@Service
public class FavoriteService {

    private final IFavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteService(IFavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    /**
     * Create a new favorite
     * @param favorite, user
     * @return The created favorite
     */
    public Favorite create(Favorite favorite, User user) {
        favorite.setUser(user);
        favoriteRepository.save(favorite);
        return favorite;
    }

//    /**
//     * Get all the favorites
//     * @return List of favorites
//     */
//    public List<Favorite> getAll() {
//        List<Favorite> favorites =  favoriteRepository.findAll();
//        return favorites;
//    }

    /**
     * Get an favorite by id
     * @param id
     * @return A favorite
     */
    public Optional<Favorite> getById(final Long id) {
        Optional<Favorite> favorite = favoriteRepository.findById(id);
        if (favorite.isEmpty()) return null;
        return favorite;
    }

//    /**
//     * Replace rows of a favorite
//     * @param newFavorite
//     * @param id
//     * @return The updated favorite
//     */
//    public Favorite update(Favorite newFavorite, final Long id) {
//        return favoriteRepository.findById(id)
//                .map(favorite -> {
//                    favorite.setTitle(newFavorite.getTitle());
//                    favorite.setJobId(newFavorite.getJobId());
//                    favorite.setDesc(newFavorite.getDesc());
//                    favorite.setLanguageCode(newFavorite.getLanguageCode());
//                    favorite.setLicenseCode(newFavorite.getLicenseCode());
//                    favorite.setLocation(newFavorite.getLocation());
//                    favoriteRepository.save(favorite);
//                    return favorite;
//                })
//                .orElseGet(() -> {
//                    newFavorite.setFavId(id);
//                    favoriteRepository.save(newFavorite);
//                    return newFavorite;
//                });
//    }

    /**
     * Delete a favorite
     * @param id
     */
    public void delete(final Long id) {
        favoriteRepository.deleteById(id);
    }


    /**
     *
     * @param id
     * @return List of user's favorites
     */
    public List<Favorite> getAllByUserId(Long id) {
        List<Favorite> favorites = favoriteRepository.findAllByUserUserId(id);
        return favorites;
    }
}
