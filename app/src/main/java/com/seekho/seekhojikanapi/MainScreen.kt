package com.seekho.seekhojikanapi

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.seekho.seekhojikanapi.viewmodel.viewmodelJikan

@Composable
fun MainScreen(viewModelObject: viewmodelJikan = hiltViewModel()) {

    val navController = rememberNavController()
//    val viewModelObject: viewmodelJikan = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = "list_screen"
    ) {
        composable("list_screen") {
            AnimeListScreen(viewModelObject) { animeId ->
                navController.navigate("item_detail/$animeId")
            }
        }
        composable("item_detail/{animeId}") { backStackEntry ->
            val animeId = backStackEntry.arguments?.getString("animeId")?.toIntOrNull()
            if (animeId != null) {
                AnimeDetailScreen(viewModelObject,animeId)
            }
        }
    }

}

