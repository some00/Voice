package voice.common.navigation

import android.net.Uri
import android.os.Bundle
import voice.common.BookId
import biz.source_code.base64Coder.Base64Coder

sealed interface NavigationCommand {
  object GoBack : NavigationCommand
  data class GoTo(val destination: Destination) : NavigationCommand
}

sealed interface Destination {
  data class Playback(val bookId: BookId) : Destination
  data class Bookmarks(val bookId: BookId) : Destination
  data class CoverFromInternet(val bookId: BookId) : Destination
  data class Website(val url: String) : Destination
  data class EditCover(val bookId: BookId, val cover: Uri) : Destination

  sealed class Compose(val route: String) : Destination
  object Migration : Compose("migration")
  object Settings : Compose("settings")
  object BookOverview : Compose("bookOverview")
  object FolderPicker : Compose("folderPicker")
  object BookSearch : Compose("bookSearch")
  data class SelectFolderType(val uri: Uri) : Compose("$baseRoute/${Base64Coder.encodeString(uri.toString())}") {
    companion object {
      private const val baseRoute = "selectFolderType"
      private const val uriArg = "uri"
      const val route = "$baseRoute/{$uriArg}"

      fun parse(bundle: Bundle): SelectFolderType {
        val uriEncoded = bundle.getString(uriArg)
        val uriString = Base64Coder.decodeString(uriEncoded!!)
        return SelectFolderType(Uri.parse(uriString))
      }
    }
  }
}
