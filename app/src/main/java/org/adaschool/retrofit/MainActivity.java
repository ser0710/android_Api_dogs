package org.adaschool.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.bumptech.glide.Glide;

import org.adaschool.retrofit.Impl.RetrofitInstance;
import org.adaschool.retrofit.databinding.ActivityMainBinding;
import org.adaschool.retrofit.entities.BreedsListDto;
import org.adaschool.retrofit.services.DogApiService;

import java.util.Map;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DogApiService dogApiService = RetrofitInstance.getRetrofitInstance().create(DogApiService.class);
        Call<BreedsListDto> call = dogApiService.getChowDogs();
        call.enqueue(new Callback<BreedsListDto>() {
            @Override
            public void onResponse(Call<BreedsListDto> call, Response<BreedsListDto> response) {
                if (response.isSuccessful()) {
                    String [] chowDogs = response.body().getMessage();
                    loadDogInfo(chowDogs);
                } else {
                    Log.e(TAG, "Error en la respuesta de la API");
                }
            }
            @Override
            public void onFailure(Call<BreedsListDto> call, Throwable t) {
                Log.e(TAG, "Error al llamar a la API", t);
            }
        });
    }
    private void loadDogInfo(String[] dogs) {
        Random random = new Random();
        int randomIndex = random.nextInt(dogs.length);
        String dogImageUrl = dogs[randomIndex];
        String dogName = "Chow";
        binding.textView.setText(dogName);
        Glide.with(this)
                .load(dogImageUrl)
                .into(binding.imageView);
    }
}
