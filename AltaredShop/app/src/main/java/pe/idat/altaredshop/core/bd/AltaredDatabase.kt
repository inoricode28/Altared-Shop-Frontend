package pe.idat.altaredshop.core.bd

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UsuarioEntity::class], version = 1)
abstract class AltaredDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao

}