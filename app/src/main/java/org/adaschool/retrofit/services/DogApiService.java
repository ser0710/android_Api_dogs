package org.adaschool.retrofit.services;

import org.adaschool.retrofit.entities.BreedsListDto;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DogApiService {
    @GET("api/breeds/list/all")
    Call<BreedsListDto> getAllBreeds();

    @GET("api/breed/chow/images")
    Call<BreedsListDto> getChowDogs();
}

