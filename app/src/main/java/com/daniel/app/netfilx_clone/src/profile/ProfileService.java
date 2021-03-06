package com.daniel.app.netfilx_clone.src.profile;

import android.util.Log;

import com.daniel.app.netfilx_clone.src.profile.interfaces.ProfileActivityView;
import com.daniel.app.netfilx_clone.src.profile.interfaces.ProfileRetrofitInterface;
import com.daniel.app.netfilx_clone.src.profile.models.ProfileAddResponse;
import com.daniel.app.netfilx_clone.src.profile.models.ProfileBody;
import com.daniel.app.netfilx_clone.src.profile.models.ProfileResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.daniel.app.netfilx_clone.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.daniel.app.netfilx_clone.src.ApplicationClass.getRetrofit;

public class ProfileService {
    private static final String TAG = "ProfileService";

    private final ProfileActivityView mProfileActivityView;

    public ProfileService(final ProfileActivityView profileActivityView) {
        this.mProfileActivityView = profileActivityView;
    }

    public void getProfiles() {
        Log.d(TAG, "getProfiles: started"+X_ACCESS_TOKEN);
        final ProfileRetrofitInterface profileRetrofitInterface = getRetrofit().create(ProfileRetrofitInterface.class);
        profileRetrofitInterface.getProfiles(X_ACCESS_TOKEN).enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                Log.d(TAG, "onResponse: get response.");
                final ProfileResponse profileResponse = response.body();
                if (profileResponse == null) {
                    Log.d(TAG, "onResponse: null");
                    mProfileActivityView.validateFailure(null);
                    return;
                }
                if(profileResponse.isSuccess()){
                    Log.d(TAG, "validateSuccess: " + profileResponse.isSuccess());
                    if(profileResponse.getCode()==100){
                        Log.d(TAG, "onResponse: " + profileResponse.getCode());
                        mProfileActivityView.validateSuccess(profileResponse.getResult(), profileResponse.getAddProfileAvailable());
                    }
                }
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: ");

                mProfileActivityView.validateFailure(null);
            }

        });
    }

    void postProfile(String profileName, int profileImgId) {
        Log.d(TAG, "getProfiles: started");
        final ProfileRetrofitInterface profileRetrofitInterface = getRetrofit().create(ProfileRetrofitInterface.class);
        profileRetrofitInterface.postProfile(X_ACCESS_TOKEN,new ProfileBody(profileName, profileImgId)).enqueue(new Callback<ProfileAddResponse>() {
            @Override
            public void onResponse(Call<ProfileAddResponse> call, Response<ProfileAddResponse> response) {
                final ProfileAddResponse profileResponse = response.body();
                Log.d(TAG, "onResponse: get response."+ profileResponse.getCode());
                if (profileResponse == null) {
                    Log.d(TAG, "onResponse: null");
                    mProfileActivityView.validateFailure(null);
                    return;
                }
                if(profileResponse.isSuccess()){
                    Log.d(TAG, "validateSuccess: " + profileResponse.isSuccess());
                    if(profileResponse.getCode()==100){
                        Log.d(TAG, "onResponse: " + profileResponse.getCode());
                        mProfileActivityView.profileAddSuccess(profileResponse.isSuccess());
                    }
                }
            }

            @Override
            public void onFailure(Call<ProfileAddResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: ");

                mProfileActivityView.validateFailure(null);
            }

        });
    }

    public void deleteProfile(int Id) {
        Log.d(TAG, "deleteProfile: started.");
        final ProfileRetrofitInterface profileRetrofitInterface = getRetrofit().create(ProfileRetrofitInterface.class);
        profileRetrofitInterface.deleteProfile(X_ACCESS_TOKEN,Id).enqueue(new Callback<ProfileAddResponse>() {
            @Override
            public void onResponse(Call<ProfileAddResponse> call, Response<ProfileAddResponse> response) {
                final ProfileAddResponse profileResponse = response.body();
                Log.d(TAG, "onResponse: get response."+ profileResponse.getCode());
                if (profileResponse == null) {
                    Log.d(TAG, "onResponse: null");
                    mProfileActivityView.validateFailure(null);
                    return;
                }
                if(profileResponse.isSuccess()){
                    Log.d(TAG, "validateSuccess: " + profileResponse.isSuccess());
                    if(profileResponse.getCode()==100){
                        Log.d(TAG, "onResponse: " + profileResponse.getCode());
                        mProfileActivityView.profileAddSuccess(profileResponse.isSuccess());
                    }
                }
            }

            @Override
            public void onFailure(Call<ProfileAddResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: ");

                mProfileActivityView.validateFailure(null);
            }

        });
    }

    public void modifyProfile(ProfileBody profileBody, int profileId) {
        Log.d(TAG, "modifyProfile: started."+"body"+profileBody.getProfileName()+profileBody.getProfileImgId()+"id"+profileId);
        final ProfileRetrofitInterface profileRetrofitInterface = getRetrofit().create(ProfileRetrofitInterface.class);
        profileRetrofitInterface.modifyProfile(X_ACCESS_TOKEN, profileId , profileBody).enqueue(new Callback<ProfileAddResponse>() {
            @Override
            public void onResponse(Call<ProfileAddResponse> call, Response<ProfileAddResponse> response) {
                final ProfileAddResponse profileResponse = response.body();
                Log.d(TAG, "onResponse: get response."+ profileResponse.getCode());
                if (profileResponse == null) {
                    Log.d(TAG, "onResponse: null");
                    mProfileActivityView.validateFailure(null);
                    return;
                }
                if(profileResponse.isSuccess()){
                    Log.d(TAG, "validateSuccess: " + profileResponse.isSuccess());
                    if(profileResponse.getCode()==100){
                        Log.d(TAG, "onResponse: " + profileResponse.getCode());
                        mProfileActivityView.profileAddSuccess(profileResponse.isSuccess());
                    }
                }
            }

            @Override
            public void onFailure(Call<ProfileAddResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: ");

                mProfileActivityView.validateFailure(null);
            }

        });
    }

}
