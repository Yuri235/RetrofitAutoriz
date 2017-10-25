package com.example.admin_user.test;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by admin-user on 25.10.17.
 */

public interface IAutorization {
    @POST("/authorization/registration")
    Call<Object> getToken(@Body AutorizationModel autorizationModel);
}
