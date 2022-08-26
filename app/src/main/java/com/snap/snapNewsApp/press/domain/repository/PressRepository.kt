package com.snap.snapNewsApp.press.domain.repository

interface PressRepository {

    suspend fun fetchTopHeadlines()
}