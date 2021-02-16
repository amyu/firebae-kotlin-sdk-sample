import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.FirebaseOptions
import dev.gitlive.firebase.firestore.firestore
import dev.gitlive.firebase.initialize
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import react.dom.render
import react.useEffect

fun main() {
    window.onload = {
        render(document.getElementById("root")) {
            child(Welcome::class) {
                useEffect {
                    GlobalScope.launch {
                        val firebaseApp = Firebase.initialize(
                            options = FirebaseOptions(
                                applicationId = "",
                                apiKey = "",
                                storageBucket = "",
                                projectId = "",
                            )
                        )

                        val firestore = Firebase.firestore(firebaseApp)

                        val newData = hashMapOf(
                            "key" to "value",
                        )
                        firestore
                            .collection("database")
                            .add(newData)
                    }
                }
                attrs {
                    name = "Kotlin/JS"
                }
            }
        }
    }
}
