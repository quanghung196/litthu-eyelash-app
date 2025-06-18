package com.example.litthu_eyelash_app.data.remote

object LitthuApiConfig {

    const val BASE_URL = "10.0.2.2"
    const val BASE_PORT = 1906

    object Timeout {
        const val CONNECT_TIMEOUT = 15000L
        const val SOCKET_TIMEOUT = 15000L
        const val REQUEST_TIMEOUT = 30000L
    }

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