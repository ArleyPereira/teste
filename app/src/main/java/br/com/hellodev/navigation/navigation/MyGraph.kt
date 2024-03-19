package br.com.hellodev.navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.hellodev.navigation.User
import br.com.hellodev.navigation.screens.HomeScreen
import br.com.hellodev.navigation.screens.ProductDetailsScreen
import br.com.hellodev.navigation.screens.ProductListScreen
import br.com.hellodev.navigation.util.fromJson
import br.com.hellodev.navigation.util.toJson

@Composable
fun SetupNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home_screen") {
        composable(route = "home_screen") {
            HomeScreen(
                navigateToProductListScreen = { name ->
                    navController.navigate("product_list_screen?name=$name")
                }
            )
        }

        composable(
            route = "product_list_screen?name={name}",
            arguments = listOf(navArgument("name") {
                type = NavType.StringType
                nullable = true
            })
        ) { navBackStackEntry ->
            val name = navBackStackEntry.arguments?.getString("name")
            val nameDefault = "Visitante"
            val result = navBackStackEntry.savedStateHandle.get<String>("result_value")
            ProductListScreen(
                name = name ?: nameDefault,
                result = result,
                navigateToProductDetailsScreen = {
                    navController.navigate("product_details_screen")
                },
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = "product_details_screen") {
            ProductDetailsScreen(
                onBackPressed = { result ->
                    navController.previousBackStackEntry
                        ?.savedStateHandle
                        ?.set("result_value", result)
                    navController.popBackStack()
                }
            )
        }
    }
}