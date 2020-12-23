package ru.android.academy.movies.Models

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import java.io.Serializable

data class Movie (
    val name:String,
    val age:String,
    @SuppressLint("SupportAnnotationUsage") @DrawableRes
    val poster:Int,
    val actors:List<Actor>,
    val favorite:Boolean,
    val genre:String,
    val rating:Float,
    val reviews:String,
    val duration:String) : Serializable
