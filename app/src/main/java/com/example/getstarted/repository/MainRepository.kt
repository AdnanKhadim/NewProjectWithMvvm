package com.example.getstarted.repository

import com.example.getstarted.utilities.retrofit.RetrofitService


class MainRepository(private val retrofitService: RetrofitService) {
    fun getAllMovies() = retrofitService.getAllMovies()
}