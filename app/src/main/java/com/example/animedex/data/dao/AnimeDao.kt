package com.example.animedex.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.animedex.data.entity.AnimeEntity
import kotlinx.coroutines.flow.Flow

// Interface DAO para acceder a los datos de anime (Parte 3 Completa)
@Dao
interface AnimeDao {

    // Obtener los anime principales ordenados por rank
    @Query("SELECT * FROM anime ORDER BY rank LIMIT :limit")
    fun topAnime(limit: Int): Flow<List<AnimeEntity>>

    // Obtener un anime por su ID
    @Query("SELECT * FROM anime WHERE anime_id = :id")
    fun byId(id: Int): Flow<AnimeEntity?>

    // Obtener el detalle de un anime junto a sus generos
    @Transaction
    @Query("SELECT * FROM anime WHERE anime_id = :id")
    fun detail(id: Int): Flow<AnimeWithGenres?>

    // 1. Buscar por titulo ordenado por rank
    @Query("SELECT * FROM anime WHERE title LIKE '%' || :text || '%' ORDER BY rank")
    fun searchByTitle(text: String): Flow<List<AnimeEntity>>

    // 2. Obtener anime por genero (JOIN con anime_genre y genre)
    @Query("SELECT a.* FROM anime a INNER JOIN anime_genre ag ON a.anime_id = ag.anime_id INNER JOIN genre g ON ag.genre_id = g.genre_id WHERE g.name = :genreName ORDER BY a.rank")
    fun byGenre(genreName: String): Flow<List<AnimeEntity>>

    // 3. Obtener anime con puntuacion minima
    @Query("SELECT * FROM anime WHERE score >= :minScore ORDER BY rank")
    fun byMinScore(minScore: Double): Flow<List<AnimeEntity>>

    // 4. Obtener anime por tipo
    @Query("SELECT * FROM anime WHERE type = :type ORDER BY rank")
    fun byType(type: String): Flow<List<AnimeEntity>>

    // 5. Obtener anime sin numero de episodios
    @Query("SELECT * FROM anime WHERE episodes IS NULL")
    fun withoutEpisodes(): Flow<List<AnimeEntity>>

    // 6. Obtener los 3 animes con mas miembros
    @Query("SELECT * FROM anime ORDER BY members DESC LIMIT 3")
    fun top3Miembros(): Flow<List<AnimeEntity>>

    // 7. Estudio con mas animes
    @Query("SELECT c.name FROM company c INNER JOIN anime_company ac ON c.company_id = ac.company_id WHERE c.company_type = 'studio' GROUP BY c.company_id ORDER BY COUNT(ac.anime_id) DESC LIMIT 1")
    fun estudioConMasAnimes(): Flow<String?>
}
