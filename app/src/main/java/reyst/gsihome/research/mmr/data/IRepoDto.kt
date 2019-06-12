package reyst.gsihome.research.mmr.data

import reyst.gsihome.research.mmr.domain.Repo

interface IRepoDto {
    val id: Int
    val name: String
    val fullName: String
}

fun IRepoDto.toDomain() = Repo(id, name, fullName)
fun Collection<IRepoDto>.toDomain() = map { it.toDomain() }
