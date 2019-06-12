package reyst.gsihome.research.repository.retrofit

import com.google.gson.annotations.SerializedName
import reyst.gsihome.research.repository.IRepoDto

data class RepoDto(

    @SerializedName("id")
    override val id: Int,

    @SerializedName("name")
    override val name: String,

    @SerializedName("full_name")
    override val fullName: String

): IRepoDto
