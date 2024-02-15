<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ProduitController;
use App\Http\Controllers\CommandeController;
/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/
Route::get('produits/commandes',[ProduitController::class,'PrdCmd']);
//Route::resource('produits',ProduitController::class);
Route::resource('commandes',CommandeController::class);

Route::group(['prefix'=>'produits'],function(){
    Route::get('/',[ProduitController::class,'index']);
    Route::get('/{id}',[ProduitController::class,'show']);
    Route::post('/',[ProduitController::class,'store']);
    Route::delete('/{id}',[ProduitController::class,'destroy']);
});



Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});
