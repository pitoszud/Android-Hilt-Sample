package com.example.hiltstudy.services

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthService @Inject constructor(
    venueService: LocalVenueService
): IAuthService {

    override fun isAuthenticated(): Boolean{
        return true
    }

}