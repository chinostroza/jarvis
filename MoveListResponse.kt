package cl.watched.movies.data.remote.model;

import com.google.gson.annotations.SerializedName

data class MoveListResponse (

    
    @SerializedName("iso_639_1")
    val iso_639_1 : String,
    
    @SerializedName("id")
    val id : Int,
    
    @SerializedName("page")
    val page : Int,
    
    @SerializedName("iso_3166_1")
    val iso_3166_1 : String,
    
    @SerializedName("total_results")
    val total_results : Int,
    
    @SerializedName("object_ids")
    val object_ids : Object_ids,
    
    @SerializedName("revenue")
    val revenue : Int,
    
    @SerializedName("total_pages")
    val total_pages : Int,
    
    @SerializedName("name")
    val name : String,
    
    @SerializedName("public")
    val public : Boolean,
    
    @SerializedName("comments")
    val comments : Comments,
    
    @SerializedName("sort_by")
    val sort_by : String,
    
    @SerializedName("description")
    val description : String,
    
    @SerializedName("backdrop_path")
    val backdrop_path : String,
    
    @SerializedName("results")
    val results : Results,
    
    @SerializedName("average_rating")
    val average_rating : Float,
    
    @SerializedName("runtime")
    val runtime : Int,
    
    @SerializedName("created_by")
    val created_by : Created_by,
    
    @SerializedName("poster_path")
    val poster_path : String,
    
)