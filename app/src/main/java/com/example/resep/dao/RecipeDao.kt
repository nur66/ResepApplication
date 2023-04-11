import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.resep.entities.Category
import com.example.resep.entities.Recipes

@Dao
interface RecipeDao {

    @get:Query("SELECT * FROM category ORDER BY id DESC")
    val getAllCategory: List<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: Category)

//    @Query("SELECT * FROM Recipes")   // jika menggunakan function tidak perlu menggunakan site target get pada prefix query nya
//    fun allRecipes() : List<Recipies>
}