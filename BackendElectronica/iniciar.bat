@echo off

:menu
cls
echo Menu de ejecucion:
echo 1. Ejecutar DATABASE
echo 2. Ejecutar APIREST
echo 3. Eliminar DATABASE
echo Q. Salir

set /p choice=Seleccione una opcion:

if "%choice%"=="1" (
    echo Ejecutando DATABASE...
    npm run babel-node src\database\db.js
) else if "%choice%"=="2" (
    echo Ejecutando APIREST...
    npm run babel-node src\index.js
)else if "%choice%"=="3" (
    echo Ejecutando ELIMINANDO DATABASE...
    npm run babel-node src\database\dbKill.js
) else if /i "%choice%"=="Q" (
    exit
) else (
    echo Opcion no valida. Intente nuevamente.
    timeout /t 2 > nul
    goto menu
)

:askToContinue
set /p continue=¿Desea regresar al menú principal? (S/N):
if /i "%continue%"=="S" (
    goto menu
) else if /i "%continue%"=="N" (
    exit
) else (
    echo Respuesta no válida. Por favor, introduzca 'S' para regresar al menú principal o 'N' para salir del programa.
    goto askToContinue
)

REM Bucle para volver a ejecutar el menú
:runAgain
echo.
echo.
echo Volviendo al menú principal...
timeout /t 2 > nul
goto menu
