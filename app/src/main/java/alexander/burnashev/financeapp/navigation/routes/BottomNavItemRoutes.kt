package alexander.burnashev.financeapp.navigation.routes

import alexander.burnashev.financeapp.R
import androidx.annotation.StringRes
import alexander.burnashev.financeapp.navigation.NavItem

sealed class BottomNavItemRoutes(
    route: String,
    var icon: Int,
    @StringRes val resourceId: Int
) : NavItem(route) {
    data object Money : BottomNavItemRoutes("money", R.drawable.ic_money, R.string.title_money)
    data object AddPayment : BottomNavItemRoutes("addpayment", R.drawable.ic_add, R.string.title_addpayment)
    data object Profile : BottomNavItemRoutes("profile", R.drawable.ic_profile, R.string.title_profile)
}

