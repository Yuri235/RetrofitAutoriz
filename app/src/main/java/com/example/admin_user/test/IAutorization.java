package com.example.admin_user.test;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by admin-user on 25.10.17.
 */

public interface IAutorization {
    @POST("http://174.138.54.52:8889/#!/authorization/authorization_registration_create")
    Call<Object> getToken(@Body AutorizationModel autorizationModel);
}
