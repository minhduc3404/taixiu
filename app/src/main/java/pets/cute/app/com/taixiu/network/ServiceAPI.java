package pets.cute.app.com.taixiu.network;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;

/**
 * Created by Forev on 7/2/2016.
 */
public interface ServiceAPI {
    String BASE_URL = " http://api.quoctehopphat.com/";

    @FormUrlEncoded
    @POST("/push_result")
    Call<JsonObject> pushResult(@Field(value = "device_id", encoded = false) String device_id,
                                @Field(value = "name_phone", encoded = false) String device_name,
                                @Field(value = "result", encoded = false) int result,
                                @Field(value = "result_num", encoded = false) int result_num);
}
