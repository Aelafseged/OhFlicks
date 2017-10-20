package com.example.aelaf.ohflicks.model;

import java.util.List;

/**
 * Author: aelaf
 * Created by: ModelGenerator on 9/14/17
 */
public class Model {
    private boolean adult;    // false
    private String backdropPath;    // /87hTDiay2N2qWy
    private BelongsToCollection belongsToCollection;
    private int budget;    // 63000000
    private List<GenresItem> genres;
    private String homepage;    // http://www.foxm
    private int id;    // 550
    private String imdbId;    // tt0137523
    private String originalLanguage;    // en
    private String originalTitle;    // FightClub
    private String overview;    // Aticking_time_b
    private double popularity;    // 38.592709
    private String posterPath;    // /adw6Lq9FiC9zjY
    private List<ProductionCompaniesItem> productionCompanies;
    private List<ProductionCountriesItem> productionCountries;
    private String releaseDate;    // 1999_10_15
    private int revenue;    // 100853753
    private int runtime;    // 139
    private List<SpokenLanguagesItem> spokenLanguages;
    private String status;    // Released
    private String tagline;    // Mischief.Mayhem
    private String title;    // FightClub
    private boolean video;    // false
    private double voteAverage;    // 8.3
    private int voteCount;    // 9144

    public boolean isAdult() {
        return adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public BelongsToCollection getBelongsToCollection() {
        return belongsToCollection;
    }

    public int getBudget() {
        return budget;
    }

    public List<GenresItem> getGenres() {
        return genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public int getId() {
        return id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public List<ProductionCompaniesItem> getProductionCompanies() {
        return productionCompanies;
    }

    public List<ProductionCountriesItem> getProductionCountries() {
        return productionCountries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getRevenue() {
        return revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public List<SpokenLanguagesItem> getSpokenLanguages() {
        return spokenLanguages;
    }

    public String getStatus() {
        return status;
    }

    public String getTagline() {
        return tagline;
    }

    public String getTitle() {
        return title;
    }

    public boolean isVideo() {
        return video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }
}