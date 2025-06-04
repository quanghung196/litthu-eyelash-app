package com.example.litthu_eyelash_app.data.remote

object LitthuApiPath {

    const val BASE_URL = "https://localhost:1906/"

    object Auth {
        const val AUTH001 = "auth/register"
        const val AUTH002 = "auth/register_staff"
        const val AUTH003 = "auth/register_admin"
        const val AUTH004 = "auth/login"
        const val AUTH005 = "auth/refresh_token"
        const val AUTH006 = "auth/logout"
        const val AUTH007 = "auth/password_reset"
    }
}