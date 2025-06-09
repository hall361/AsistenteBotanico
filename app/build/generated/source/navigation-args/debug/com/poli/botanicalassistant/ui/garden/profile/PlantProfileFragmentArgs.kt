package com.poli.botanicalassistant.ui.garden.profile

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.poli.botanicalassistant.ui.garden.model.PlantUi
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class PlantProfileFragmentArgs(
  public val plant: PlantUi,
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(PlantUi::class.java)) {
      result.putParcelable("plant", this.plant as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(PlantUi::class.java)) {
      result.putSerializable("plant", this.plant as Serializable)
    } else {
      throw UnsupportedOperationException(PlantUi::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(PlantUi::class.java)) {
      result.set("plant", this.plant as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(PlantUi::class.java)) {
      result.set("plant", this.plant as Serializable)
    } else {
      throw UnsupportedOperationException(PlantUi::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): PlantProfileFragmentArgs {
      bundle.setClassLoader(PlantProfileFragmentArgs::class.java.classLoader)
      val __plant : PlantUi?
      if (bundle.containsKey("plant")) {
        if (Parcelable::class.java.isAssignableFrom(PlantUi::class.java) ||
            Serializable::class.java.isAssignableFrom(PlantUi::class.java)) {
          __plant = bundle.get("plant") as PlantUi?
        } else {
          throw UnsupportedOperationException(PlantUi::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__plant == null) {
          throw IllegalArgumentException("Argument \"plant\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"plant\" is missing and does not have an android:defaultValue")
      }
      return PlantProfileFragmentArgs(__plant)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): PlantProfileFragmentArgs {
      val __plant : PlantUi?
      if (savedStateHandle.contains("plant")) {
        if (Parcelable::class.java.isAssignableFrom(PlantUi::class.java) ||
            Serializable::class.java.isAssignableFrom(PlantUi::class.java)) {
          __plant = savedStateHandle.get<PlantUi?>("plant")
        } else {
          throw UnsupportedOperationException(PlantUi::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__plant == null) {
          throw IllegalArgumentException("Argument \"plant\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"plant\" is missing and does not have an android:defaultValue")
      }
      return PlantProfileFragmentArgs(__plant)
    }
  }
}
