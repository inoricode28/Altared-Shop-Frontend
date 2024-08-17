package pe.idat.altaredshop.core.bd

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertarUsuario(vararg usuarioEntity: UsuarioEntity)

    @Update
    suspend fun actualizarUsuario(vararg usuarioEntity: UsuarioEntity)

    @Query("DELETE FROM usuario")
    suspend fun eliminarUsuario()

    @Query("SELECT * FROM usuario LIMIT 1")
    fun obtenerUsuario(): LiveData<UsuarioEntity>
}