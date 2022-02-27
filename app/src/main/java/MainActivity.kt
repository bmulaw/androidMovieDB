
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.rkpandey.flixster.Movie
import okhttp3.Headers
import org.json.JSONException

private const val TAG = "MainActivity"
private const val URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=add0f760a52cfaca1a0b22c2703d315f"
class MainActivity : AppCompatActivity() {
    private val movies = mutableListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val movieAdapter = MovieAdapter(this, movies)

        val client = AsyncHttpClient()
        client.get(URL, object: JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON) {
                // called when response HTTP status is "200 OK"
                Log.i(TAG, "onSuccess: JSON data $json")
                try {
                    val movieDataArray = json.jsonObject.getJSONArray("results")
                    movies.add(Movie.fromJsonArray(movieDataArray))
                    Log.i(TAG, "MOVIES LIST $movies")
                } catch(e: JSONException) {
                    Log.e(TAG, "Error $e")
                }

            }

            override fun onFailure(statusCode: Int, headers: Headers?, errorResponse: String, t: Throwable) {
                // called when response
                Log.e(TAG, "onFailure $statusCode")
            }
        })

    }
}