package pe.idat.altaredshop.core.bd

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AltaredDbModule {

    @Provides
    fun provideUsuarioDao(altaredDatabase: AltaredDatabase): UsuarioDao{
        return altaredDatabase.usuarioDao()
    }


    @Provides
    @Singleton
    fun provideAltaredDatabase(@ApplicationContext context: Context): AltaredDatabase{
        return Room.databaseBuilder(context,
            AltaredDatabase::class.java,
            "altareddb").build()
    }

}