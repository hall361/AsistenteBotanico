package com.poli.botanicalassistant.ui.garden.list

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.poli.botanicalassistant.R
import com.poli.botanicalassistant.ui.garden.model.PlantUi
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class GardenFragmentDirections private constructor() {
  private data class ActionNavGardenToPlantProfileFragment(
    public val plant: PlantUi,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_nav_garden_to_plantProfileFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
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
  }

  public companion object {
    public fun actionNavGardenToPlantProfileFragment(plant: PlantUi): NavDirections =
        ActionNavGardenToPlantProfileFragment(plant)
  }
}
