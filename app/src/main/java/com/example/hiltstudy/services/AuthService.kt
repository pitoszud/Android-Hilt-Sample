package com.example.hiltstudy.services

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthService
@Inject
constructor(){

    fun isAuthenticated(): Boolean{
        return true
    }

}