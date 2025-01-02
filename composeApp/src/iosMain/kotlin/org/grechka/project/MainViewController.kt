package org.grechka.project

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName
import cafe.adriel.voyager.navigator.Navigator

@OptIn(ExperimentalObjCName::class)
@ObjCName("MainViewControllerProvider", exact = true)
object MainViewControllerProvider {
    fun create(): UIViewController {
        return ComposeUIViewController {
            Navigator(screen = HomeScreen()) // Replace with your actual Composable
        }
    }
}
