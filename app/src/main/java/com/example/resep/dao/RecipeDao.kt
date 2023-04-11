import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.resep.entities.Category
import com.example.resep.entities.CategoryItems
import com.example.resep.entities.Recipes

@Dao
interface RecipeDao {

    @Query("SELECT * FROM categoryitems ORDER BY id DESC")
    suspend fun getAllCategory(): List<CategoryItems>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(categoryItems: CategoryItems?)

    @Query("DELETE FROM categoryitems")
    suspend fun clearDb()

//    @Query("SELECT * FROM Recipes")   // jika menggunakan function tidak perlu menggunakan site target get pada prefix query nya
//    fun allRecipes() : List<Recipies>
}