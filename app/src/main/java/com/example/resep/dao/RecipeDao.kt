import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.resep.entities.Recipies

@Dao
interface RecipeDao {

    @get:Query("SELECT * FROM recipes")
    val allRecipes: List<Recipies>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecipe(recipies: Recipies)

//    @Query("SELECT * FROM Recipes")   // jika menggunakan function tidak perlu menggunakan site target get pada prefix query nya
//    fun allRecipes() : List<Recipies>
}