package ru.mirea.prac8.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import ru.mirea.prac8.ui.theme.backgroundDark
import ru.mirea.prac8.ui.theme.backgroundDarkHighContrast
import ru.mirea.prac8.ui.theme.backgroundDarkMediumContrast
import ru.mirea.prac8.ui.theme.backgroundLight
import ru.mirea.prac8.ui.theme.backgroundLightHighContrast
import ru.mirea.prac8.ui.theme.backgroundLightMediumContrast
import ru.mirea.prac8.ui.theme.errorContainerDark
import ru.mirea.prac8.ui.theme.errorContainerDarkHighContrast
import ru.mirea.prac8.ui.theme.errorContainerDarkMediumContrast
import ru.mirea.prac8.ui.theme.errorContainerLight
import ru.mirea.prac8.ui.theme.errorContainerLightHighContrast
import ru.mirea.prac8.ui.theme.errorContainerLightMediumContrast
import ru.mirea.prac8.ui.theme.errorDark
import ru.mirea.prac8.ui.theme.errorDarkHighContrast
import ru.mirea.prac8.ui.theme.errorDarkMediumContrast
import ru.mirea.prac8.ui.theme.errorLight
import ru.mirea.prac8.ui.theme.errorLightHighContrast
import ru.mirea.prac8.ui.theme.errorLightMediumContrast
import ru.mirea.prac8.ui.theme.inverseOnSurfaceDark
import ru.mirea.prac8.ui.theme.inverseOnSurfaceDarkHighContrast
import ru.mirea.prac8.ui.theme.inverseOnSurfaceDarkMediumContrast
import ru.mirea.prac8.ui.theme.inverseOnSurfaceLight
import ru.mirea.prac8.ui.theme.inverseOnSurfaceLightHighContrast
import ru.mirea.prac8.ui.theme.inverseOnSurfaceLightMediumContrast
import ru.mirea.prac8.ui.theme.inversePrimaryDark
import ru.mirea.prac8.ui.theme.inversePrimaryDarkHighContrast
import ru.mirea.prac8.ui.theme.inversePrimaryDarkMediumContrast
import ru.mirea.prac8.ui.theme.inversePrimaryLight
import ru.mirea.prac8.ui.theme.inversePrimaryLightHighContrast
import ru.mirea.prac8.ui.theme.inversePrimaryLightMediumContrast
import ru.mirea.prac8.ui.theme.inverseSurfaceDark
import ru.mirea.prac8.ui.theme.inverseSurfaceDarkHighContrast
import ru.mirea.prac8.ui.theme.inverseSurfaceDarkMediumContrast
import ru.mirea.prac8.ui.theme.inverseSurfaceLight
import ru.mirea.prac8.ui.theme.inverseSurfaceLightHighContrast
import ru.mirea.prac8.ui.theme.inverseSurfaceLightMediumContrast
import ru.mirea.prac8.ui.theme.onBackgroundDark
import ru.mirea.prac8.ui.theme.onBackgroundDarkHighContrast
import ru.mirea.prac8.ui.theme.onBackgroundDarkMediumContrast
import ru.mirea.prac8.ui.theme.onBackgroundLight
import ru.mirea.prac8.ui.theme.onBackgroundLightHighContrast
import ru.mirea.prac8.ui.theme.onBackgroundLightMediumContrast
import ru.mirea.prac8.ui.theme.onErrorContainerDark
import ru.mirea.prac8.ui.theme.onErrorContainerDarkHighContrast
import ru.mirea.prac8.ui.theme.onErrorContainerDarkMediumContrast
import ru.mirea.prac8.ui.theme.onErrorContainerLight
import ru.mirea.prac8.ui.theme.onErrorContainerLightHighContrast
import ru.mirea.prac8.ui.theme.onErrorContainerLightMediumContrast
import ru.mirea.prac8.ui.theme.onErrorDark
import ru.mirea.prac8.ui.theme.onErrorDarkHighContrast
import ru.mirea.prac8.ui.theme.onErrorDarkMediumContrast
import ru.mirea.prac8.ui.theme.onErrorLight
import ru.mirea.prac8.ui.theme.onErrorLightHighContrast
import ru.mirea.prac8.ui.theme.onErrorLightMediumContrast
import ru.mirea.prac8.ui.theme.onPrimaryContainerDark
import ru.mirea.prac8.ui.theme.onPrimaryContainerDarkHighContrast
import ru.mirea.prac8.ui.theme.onPrimaryContainerDarkMediumContrast
import ru.mirea.prac8.ui.theme.onPrimaryContainerLight
import ru.mirea.prac8.ui.theme.onPrimaryContainerLightHighContrast
import ru.mirea.prac8.ui.theme.onPrimaryContainerLightMediumContrast
import ru.mirea.prac8.ui.theme.onPrimaryDark
import ru.mirea.prac8.ui.theme.onPrimaryDarkHighContrast
import ru.mirea.prac8.ui.theme.onPrimaryDarkMediumContrast
import ru.mirea.prac8.ui.theme.onPrimaryLight
import ru.mirea.prac8.ui.theme.onPrimaryLightHighContrast
import ru.mirea.prac8.ui.theme.onPrimaryLightMediumContrast
import ru.mirea.prac8.ui.theme.onSecondaryContainerDark
import ru.mirea.prac8.ui.theme.onSecondaryContainerDarkHighContrast
import ru.mirea.prac8.ui.theme.onSecondaryContainerDarkMediumContrast
import ru.mirea.prac8.ui.theme.onSecondaryContainerLight
import ru.mirea.prac8.ui.theme.onSecondaryContainerLightHighContrast
import ru.mirea.prac8.ui.theme.onSecondaryContainerLightMediumContrast
import ru.mirea.prac8.ui.theme.onSecondaryDark
import ru.mirea.prac8.ui.theme.onSecondaryDarkHighContrast
import ru.mirea.prac8.ui.theme.onSecondaryDarkMediumContrast
import ru.mirea.prac8.ui.theme.onSecondaryLight
import ru.mirea.prac8.ui.theme.onSecondaryLightHighContrast
import ru.mirea.prac8.ui.theme.onSecondaryLightMediumContrast
import ru.mirea.prac8.ui.theme.onSurfaceDark
import ru.mirea.prac8.ui.theme.onSurfaceDarkHighContrast
import ru.mirea.prac8.ui.theme.onSurfaceDarkMediumContrast
import ru.mirea.prac8.ui.theme.onSurfaceLight
import ru.mirea.prac8.ui.theme.onSurfaceLightHighContrast
import ru.mirea.prac8.ui.theme.onSurfaceLightMediumContrast
import ru.mirea.prac8.ui.theme.onSurfaceVariantDark
import ru.mirea.prac8.ui.theme.onSurfaceVariantDarkHighContrast
import ru.mirea.prac8.ui.theme.onSurfaceVariantDarkMediumContrast
import ru.mirea.prac8.ui.theme.onSurfaceVariantLight
import ru.mirea.prac8.ui.theme.onSurfaceVariantLightHighContrast
import ru.mirea.prac8.ui.theme.onSurfaceVariantLightMediumContrast
import ru.mirea.prac8.ui.theme.onTertiaryContainerDark
import ru.mirea.prac8.ui.theme.onTertiaryContainerDarkHighContrast
import ru.mirea.prac8.ui.theme.onTertiaryContainerDarkMediumContrast
import ru.mirea.prac8.ui.theme.onTertiaryContainerLight
import ru.mirea.prac8.ui.theme.onTertiaryContainerLightHighContrast
import ru.mirea.prac8.ui.theme.onTertiaryContainerLightMediumContrast
import ru.mirea.prac8.ui.theme.onTertiaryDark
import ru.mirea.prac8.ui.theme.onTertiaryDarkHighContrast
import ru.mirea.prac8.ui.theme.onTertiaryDarkMediumContrast
import ru.mirea.prac8.ui.theme.onTertiaryLight
import ru.mirea.prac8.ui.theme.onTertiaryLightHighContrast
import ru.mirea.prac8.ui.theme.onTertiaryLightMediumContrast
import ru.mirea.prac8.ui.theme.outlineDark
import ru.mirea.prac8.ui.theme.outlineDarkHighContrast
import ru.mirea.prac8.ui.theme.outlineDarkMediumContrast
import ru.mirea.prac8.ui.theme.outlineLight
import ru.mirea.prac8.ui.theme.outlineLightHighContrast
import ru.mirea.prac8.ui.theme.outlineLightMediumContrast
import ru.mirea.prac8.ui.theme.outlineVariantDark
import ru.mirea.prac8.ui.theme.outlineVariantDarkHighContrast
import ru.mirea.prac8.ui.theme.outlineVariantDarkMediumContrast
import ru.mirea.prac8.ui.theme.outlineVariantLight
import ru.mirea.prac8.ui.theme.outlineVariantLightHighContrast
import ru.mirea.prac8.ui.theme.outlineVariantLightMediumContrast
import ru.mirea.prac8.ui.theme.primaryContainerDark
import ru.mirea.prac8.ui.theme.primaryContainerDarkHighContrast
import ru.mirea.prac8.ui.theme.primaryContainerDarkMediumContrast
import ru.mirea.prac8.ui.theme.primaryContainerLight
import ru.mirea.prac8.ui.theme.primaryContainerLightHighContrast
import ru.mirea.prac8.ui.theme.primaryContainerLightMediumContrast
import ru.mirea.prac8.ui.theme.primaryDark
import ru.mirea.prac8.ui.theme.primaryDarkHighContrast
import ru.mirea.prac8.ui.theme.primaryDarkMediumContrast
import ru.mirea.prac8.ui.theme.primaryLight
import ru.mirea.prac8.ui.theme.primaryLightHighContrast
import ru.mirea.prac8.ui.theme.primaryLightMediumContrast
import ru.mirea.prac8.ui.theme.scrimDark
import ru.mirea.prac8.ui.theme.scrimDarkHighContrast
import ru.mirea.prac8.ui.theme.scrimDarkMediumContrast
import ru.mirea.prac8.ui.theme.scrimLight
import ru.mirea.prac8.ui.theme.scrimLightHighContrast
import ru.mirea.prac8.ui.theme.scrimLightMediumContrast
import ru.mirea.prac8.ui.theme.secondaryContainerDark
import ru.mirea.prac8.ui.theme.secondaryContainerDarkHighContrast
import ru.mirea.prac8.ui.theme.secondaryContainerDarkMediumContrast
import ru.mirea.prac8.ui.theme.secondaryContainerLight
import ru.mirea.prac8.ui.theme.secondaryContainerLightHighContrast
import ru.mirea.prac8.ui.theme.secondaryContainerLightMediumContrast
import ru.mirea.prac8.ui.theme.secondaryDark
import ru.mirea.prac8.ui.theme.secondaryDarkHighContrast
import ru.mirea.prac8.ui.theme.secondaryDarkMediumContrast
import ru.mirea.prac8.ui.theme.secondaryLight
import ru.mirea.prac8.ui.theme.secondaryLightHighContrast
import ru.mirea.prac8.ui.theme.secondaryLightMediumContrast
import ru.mirea.prac8.ui.theme.surfaceBrightDark
import ru.mirea.prac8.ui.theme.surfaceBrightDarkHighContrast
import ru.mirea.prac8.ui.theme.surfaceBrightDarkMediumContrast
import ru.mirea.prac8.ui.theme.surfaceBrightLight
import ru.mirea.prac8.ui.theme.surfaceBrightLightHighContrast
import ru.mirea.prac8.ui.theme.surfaceBrightLightMediumContrast
import ru.mirea.prac8.ui.theme.surfaceContainerDark
import ru.mirea.prac8.ui.theme.surfaceContainerDarkHighContrast
import ru.mirea.prac8.ui.theme.surfaceContainerDarkMediumContrast
import ru.mirea.prac8.ui.theme.surfaceContainerHighDark
import ru.mirea.prac8.ui.theme.surfaceContainerHighDarkHighContrast
import ru.mirea.prac8.ui.theme.surfaceContainerHighDarkMediumContrast
import ru.mirea.prac8.ui.theme.surfaceContainerHighLight
import ru.mirea.prac8.ui.theme.surfaceContainerHighLightHighContrast
import ru.mirea.prac8.ui.theme.surfaceContainerHighLightMediumContrast
import ru.mirea.prac8.ui.theme.surfaceContainerHighestDark
import ru.mirea.prac8.ui.theme.surfaceContainerHighestDarkHighContrast
import ru.mirea.prac8.ui.theme.surfaceContainerHighestDarkMediumContrast
import ru.mirea.prac8.ui.theme.surfaceContainerHighestLight
import ru.mirea.prac8.ui.theme.surfaceContainerHighestLightHighContrast
import ru.mirea.prac8.ui.theme.surfaceContainerHighestLightMediumContrast
import ru.mirea.prac8.ui.theme.surfaceContainerLight
import ru.mirea.prac8.ui.theme.surfaceContainerLightHighContrast
import ru.mirea.prac8.ui.theme.surfaceContainerLightMediumContrast
import ru.mirea.prac8.ui.theme.surfaceContainerLowDark
import ru.mirea.prac8.ui.theme.surfaceContainerLowDarkHighContrast
import ru.mirea.prac8.ui.theme.surfaceContainerLowDarkMediumContrast
import ru.mirea.prac8.ui.theme.surfaceContainerLowLight
import ru.mirea.prac8.ui.theme.surfaceContainerLowLightHighContrast
import ru.mirea.prac8.ui.theme.surfaceContainerLowLightMediumContrast
import ru.mirea.prac8.ui.theme.surfaceContainerLowestDark
import ru.mirea.prac8.ui.theme.surfaceContainerLowestDarkHighContrast
import ru.mirea.prac8.ui.theme.surfaceContainerLowestDarkMediumContrast
import ru.mirea.prac8.ui.theme.surfaceContainerLowestLight
import ru.mirea.prac8.ui.theme.surfaceContainerLowestLightHighContrast
import ru.mirea.prac8.ui.theme.surfaceContainerLowestLightMediumContrast
import ru.mirea.prac8.ui.theme.surfaceDark
import ru.mirea.prac8.ui.theme.surfaceDarkHighContrast
import ru.mirea.prac8.ui.theme.surfaceDarkMediumContrast
import ru.mirea.prac8.ui.theme.surfaceDimDark
import ru.mirea.prac8.ui.theme.surfaceDimDarkHighContrast
import ru.mirea.prac8.ui.theme.surfaceDimDarkMediumContrast
import ru.mirea.prac8.ui.theme.surfaceDimLight
import ru.mirea.prac8.ui.theme.surfaceDimLightHighContrast
import ru.mirea.prac8.ui.theme.surfaceDimLightMediumContrast
import ru.mirea.prac8.ui.theme.surfaceLight
import ru.mirea.prac8.ui.theme.surfaceLightHighContrast
import ru.mirea.prac8.ui.theme.surfaceLightMediumContrast
import ru.mirea.prac8.ui.theme.surfaceVariantDark
import ru.mirea.prac8.ui.theme.surfaceVariantDarkHighContrast
import ru.mirea.prac8.ui.theme.surfaceVariantDarkMediumContrast
import ru.mirea.prac8.ui.theme.surfaceVariantLight
import ru.mirea.prac8.ui.theme.surfaceVariantLightHighContrast
import ru.mirea.prac8.ui.theme.surfaceVariantLightMediumContrast
import ru.mirea.prac8.ui.theme.tertiaryContainerDark
import ru.mirea.prac8.ui.theme.tertiaryContainerDarkHighContrast
import ru.mirea.prac8.ui.theme.tertiaryContainerDarkMediumContrast
import ru.mirea.prac8.ui.theme.tertiaryContainerLight
import ru.mirea.prac8.ui.theme.tertiaryContainerLightHighContrast
import ru.mirea.prac8.ui.theme.tertiaryContainerLightMediumContrast
import ru.mirea.prac8.ui.theme.tertiaryDark
import ru.mirea.prac8.ui.theme.tertiaryDarkHighContrast
import ru.mirea.prac8.ui.theme.tertiaryDarkMediumContrast
import ru.mirea.prac8.ui.theme.tertiaryLight
import ru.mirea.prac8.ui.theme.tertiaryLightHighContrast
import ru.mirea.prac8.ui.theme.tertiaryLightMediumContrast

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}

