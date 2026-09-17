package com.example.studentregistration

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object Registration : Screen("registration", "Home", Icons.Default.Home)
    object Profile : Screen("profile", "Profile", Icons.Default.Person)
    object Settings : Screen("settings", "Settings", Icons.Default.Settings)
}

/**
 * Screen 4 — Navigation.
 * Bottom Navigation bar hosts three destinations: Home (Registration),
 * Profile, Settings. The REGISTER button on the Registration screen also
 * navigates programmatically to Profile (see the Event Chain in Step 12).
 */
@Composable
fun AppNavigation(viewModel: StudentViewModel) {
    val navController = rememberNavController()
    val items = listOf(Screen.Registration, Screen.Profile, Screen.Settings)

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                items.forEach { screen ->
                    NavigationBarItem(
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(screen.icon, contentDescription = screen.label) },
                        label = { Text(screen.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Registration.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Registration.route) {
                RegistrationScreen(
                    viewModel = viewModel,
                    onRegisterSuccess = {
                        // Event Chain: REGISTER -> onClick -> registered = true -> navigate()
                        navController.navigate(Screen.Profile.route) {
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen(viewModel = viewModel)
            }
            composable(Screen.Settings.route) {
                SettingsScreen(viewModel = viewModel)
            }
        }
    }
}