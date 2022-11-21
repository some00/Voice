package voice.playback.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import voice.playback.R
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject
import javax.inject.Singleton

const val MUSIC_CHANNEL_ID = "musicChannel4"

@Singleton
class NotificationChannelCreator
@Inject constructor(
  private val notificationManager: NotificationManager,
  private val context: Context,
) {

  fun createChannel() {
  }
}
