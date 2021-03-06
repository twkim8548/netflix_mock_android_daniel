package com.daniel.app.netfilx_clone.src.signin.models;

import com.google.gson.annotations.SerializedName;

public class SignInResponse {

    @SerializedName("jwt")
    private String jwt;

    @SerializedName("userId")
    private int userId;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public SignInResponse(String jwt, int userId, boolean isSuccess, int code, String message) {
        this.jwt = jwt;
        this.userId = userId;
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
