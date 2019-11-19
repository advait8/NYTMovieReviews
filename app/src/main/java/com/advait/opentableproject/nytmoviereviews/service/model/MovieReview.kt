package com.advait.opentableproject.nytmoviereviews.service.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName

data class MultiMedia(val src: String, val width: Int, val height: Int)

data class Link(
    val type: String,
    val url: String,
    @SerializedName(value = "suggested_link_text")
    val suggestedText: String
)

class MovieReview(
    @SerializedName(value = "display_title")
    val displayTitle: String,

    @SerializedName(value = "mpaa_rating")
    val mpaaRating: String,

    val byline: String,
    val headline: String,

    @SerializedName(value = "summary_short")
    val summaryShort: String,

    @SerializedName(value = "publication_date")
    val publicationDate: String,
    val link: Link,
    val multimedia: MultiMedia
)

data class MovieReviewList(
    val movieReviewList: ArrayList<MovieReview>
)
