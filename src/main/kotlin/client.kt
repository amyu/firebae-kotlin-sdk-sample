import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.FirebaseOptions
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.firebase
import dev.gitlive.firebase.firestore.firestore
import dev.gitlive.firebase.initialize
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import react.RProps
import react.child
import react.dom.render
import react.functionalComponent
import react.useEffect

fun main() {
    window.onload = {
        render(document.getElementById("root")) {
            child(HogePage)
        }
    }
}


val HogePage = functionalComponent<RProps> {
    useEffect {
        GlobalScope.launch {

            /**
             * Bad
             */
            /*
            import dev.gitlive.firebase.Firebase
            import dev.gitlive.firebase.FirebaseOptions
            import dev.gitlive.firebase.firestore.firestore
            import dev.gitlive.firebase.initialize

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
                .add(newData)*/


            /**
             * Good!!
             */
            //add implementation("dev.gitlive:firebase-common-js:1.2.0")

            /*import dev.gitlive.firebase.Firebase
            import dev.gitlive.firebase.FirebaseOptions
            import dev.gitlive.firebase.auth.auth
            import dev.gitlive.firebase.firebase
            import dev.gitlive.firebase.firestore.firestore
            import dev.gitlive.firebase.initialize*/
            val firebaseApp = Firebase.initialize(
                options = FirebaseOptions(
                    applicationId = "",
                    apiKey = "",
                    storageBucket = "",
                    projectId = "",
                )
            )

            val firestore: firebase.firestore.Firestore = Firebase.firestore(firebaseApp).js

            val firebaseAuth: firebase.auth.Auth = Firebase.auth(firebaseApp).js
        }
    }
}