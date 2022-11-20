package voice.playbackScreen

import android.app.Application
import android.os.PowerManager
import androidx.core.content.getSystemService
import javax.inject.Inject

class BatteryOptimization
@Inject constructor(
  private val context: Application,
) {

  fun isIgnoringBatteryOptimizations(): Boolean {
    return true
  }
}
