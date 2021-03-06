package telvape.mobilau.network;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import telvape.mobilau.model.JuiceResponse;

/**
 *
 * Created by sbabu on 3/21/18.
 */

public interface JuiceFetchInterface {

    @GET("12pckb")
    Call<JuiceResponse> getJuices();

    class JuicesFetchAPI{
        private static JuiceFetchInterface juiceFetchInterface;

        public static JuiceFetchInterface api(){
            if (juiceFetchInterface == null) {
                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.myjson.com/bins/").addConverterFactory(GsonConverterFactory.create(new Gson())).build();
                juiceFetchInterface = retrofit.create(JuiceFetchInterface.class);
            }
            return juiceFetchInterface;
        }
    }

}
